package vn.iomedia.ipay.serviceImpl;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.OnlinePaymentDetail;
import vn.iomedia.ipay.entity.RegistrationDetail;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.PaymentService;
import vn.iomedia.ipay.service.RegAdmissionService;
import vn.iomedia.ipay.service.StudentService;

public class PaymentServiceImpl implements PaymentService {

    private Logger log = Logger.getLogger(PaymentServiceImpl.class);

    private RegAdmissionService regService = new RegAdmissionServiceImpl();
    private StudentService stuService = new StudentServiceImpl();

    @Override
    public OnlinePaymentDetail paymentByMobileCard(String mobileCompany, String codeMobile, String seriMobile) {
        OnlinePaymentDetail paymentResult = new OnlinePaymentDetail();
        paymentResult.setAggreTransactionId((new Random()).nextInt());
        paymentResult.setTransId((new Random()).nextInt());
        paymentResult.setStatusTrans(Boolean.TRUE);
        return paymentResult;
    }

    @Override
    public void saveDetailCart(List<RegistrationDetail> listDetail, OnlinePaymentDetail paymentResult, Student stu) {
        EntityManager em = SQLConnection.getConnection();
        try {
            if (stu.getNumberRegis() == 2) {
                log.debug("student still 2 registration number,save to DB.");
                saveDataCartToDB(listDetail, paymentResult);
                stuService.updateNumberAndDateRegis(stu, stu.getNumberRegis() - 1);

            } else if (stu.getNumberRegis() == 1) {
                log.debug("student have only 1 registration,call to get old regis.");
                List<RegistrationDetail> listDetailOld = regService.getListRegistrationByStudentId(stu.getId());
                // entity Manager had been close here,need to open again.
                if (CollectionUtils.isEmpty(listDetailOld)) {
                    log.debug("old list registration is empty,save new list regis.");
                    saveDataCartToDB(listDetail, paymentResult);
                    stuService.updateNumberAndDateRegis(stu, stu.getNumberRegis() - 1);
                } else {
                    log.debug("delete old regis then save new list");
                    em = SQLConnection.getConnection();
                    em.getTransaction().begin();
                    for (RegistrationDetail oldDetail : listDetailOld) {
                        if (!em.contains(oldDetail)) {
                            oldDetail = em.merge(oldDetail);
                        }
                        em.remove(oldDetail);
                    }
                    em.getTransaction().commit();
                    saveDataCartToDB(listDetail, paymentResult);
                    stuService.updateNumberAndDateRegis(stu, stu.getNumberRegis() - 1);
                }
            }
        } catch (Exception exp) {
            log.error(exp.getMessage());
        } finally {
            SQLConnection.closeConnection();
        }
    }

    private void saveDataCartToDB(List<RegistrationDetail> listDetail, OnlinePaymentDetail paymentResult) {
        log.debug("save new registration to DB");
        EntityManager em = SQLConnection.getConnection();
        em.getTransaction().begin();
        try {
            for (RegistrationDetail detail : listDetail) {
                em.persist(paymentResult);
                detail.setOnlinePaymentDetail(paymentResult);
                em.persist(detail);
            }
            em.getTransaction().commit();
        } catch (Exception exp) {
            log.error(exp.getMessage());
        } finally {
            SQLConnection.closeConnection();
        }
    }

}
