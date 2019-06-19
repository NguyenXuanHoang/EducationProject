package vn.iomedia.ipay.serviceImpl;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import vn.iomedia.ipay.Contanst.CommonContanst;
import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.OnlinePaymentDetail;
import vn.iomedia.ipay.entity.RegistrationDetail;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.PaymentService;
import vn.iomedia.ipay.service.RegAdmissionService;
import vn.iomedia.ipay.service.StudentService;
import vn.iomedia.ipay.utils.ObjectUtils;

public class PaymentServiceImpl implements PaymentService {

    private Log log = LogFactory.getLog(PaymentServiceImpl.class);
    private EntityManager em = SQLConnection.getConnection();
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
        try {
            if (stu.getNumberRegis() == 2) {
                log.debug("student still 2 registration number,save to DB.");
                saveDataCartToDB(listDetail, paymentResult, stu);
                stuService.updateNumberRegis(stu, stu.getNumberRegis() - 1);

            } else if (stu.getNumberRegis() == 1) {
                log.debug("student have only 1 registration,call to get old regis.");
                List<RegistrationDetail> listDetailOld = regService.getListRegistrationByStudentId(stu.getId());
                if (CollectionUtils.isEmpty(listDetailOld)) {
                    log.debug("old list registration is empty,save new list regis.");
                    saveDataCartToDB(listDetail, paymentResult, stu);
                    stuService.updateNumberRegis(stu, stu.getNumberRegis() - 1);
                } else {
                    log.debug("delete old regis then save new list");
                    for (RegistrationDetail oldDetail : listDetailOld) {
                        em.getTransaction().begin();
                        if (!em.contains(oldDetail)) {
                            oldDetail = em.merge(oldDetail);
                        }
                        em.remove(oldDetail);
                        em.getTransaction().commit();
                    }
                    saveDataCartToDB(listDetail, paymentResult, stu);
                    stuService.updateNumberRegis(stu, stu.getNumberRegis() - 1);
                }
            }
        } catch (Exception exp) {
            log.error(exp.getStackTrace());
        }
    }

    private void saveDataCartToDB(List<RegistrationDetail> listDetail, OnlinePaymentDetail paymentResult, Student stu) {
        log.debug("save new registration to DB");
        em.getTransaction().begin();
        try {
            for (RegistrationDetail detail : listDetail) {
                em.persist(paymentResult);
                detail.setOnlinePaymentDetail(paymentResult);
                em.persist(detail);
            }
            em.getTransaction().commit();
            stu.setNumberRegis(stu.getNumberRegis() - 1);
            ObjectUtils.putObjectContext(CommonContanst.STUDENT, stu);
        } catch (Exception exp) {
            log.error(exp);
        }
    }

}
