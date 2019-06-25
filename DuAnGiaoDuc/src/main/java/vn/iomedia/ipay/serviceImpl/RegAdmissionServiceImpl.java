package vn.iomedia.ipay.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.RegistrationDetail;
import vn.iomedia.ipay.service.RegAdmissionService;

public class RegAdmissionServiceImpl implements RegAdmissionService {

    private Logger log = Logger.getLogger(RegAdmissionServiceImpl.class);

    @SuppressWarnings("unchecked") @Override public List<RegistrationDetail> getListRegistrationByStudentId(
            int studentId) {
        EntityManager em = SQLConnection.getConnection();
        try {
            List<RegistrationDetail> listDetail = em.createQuery(
                    "SELECT reg FROM RegistrationDetail reg WHERE reg.student.id = :id AND reg.onlinePaymentDetail IS NOT NULL ORDER BY reg.orderAspiration ASC")
                    .setParameter("id", studentId).getResultList();
            return listDetail;
        } catch (Exception exp) {
            log.error(exp.getMessage());
            return null;
        } finally {
            SQLConnection.closeConnection();
        }
    }

}
