package vn.iomedia.ipay.serviceImpl;

import javax.persistence.EntityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private Log log = LogFactory.getLog(StudentServiceImpl.class);

    EntityManager em = SQLConnection.getConnection();

    @SuppressWarnings("unused")
    @Override
    public void updatePass(Student student, String newPass) {
        try {
            em.getTransaction().begin();
            int id = em.createQuery("UPDATE Student SET password = :newPass WHERE id = :id")
                    .setParameter("newPass", newPass).setParameter("id", student.getId()).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception exp) {
            log.error(exp);
        }
    }

    @SuppressWarnings("unused")
    @Override
    public void updateNumberRegis(Student student, int number) {
        if (number >= 0) {
            log.debug("numerRegis >= 0,update student");
            try {
                em.getTransaction().begin();
                int id = em.createQuery("UPDATE Student SET numberRegis = :number WHERE id = :id")
                        .setParameter("number", number).setParameter("id", student.getId()).executeUpdate();
                em.getTransaction().commit();
            } catch (Exception exp) {
                log.error(exp);
            }
        }
    }

}
