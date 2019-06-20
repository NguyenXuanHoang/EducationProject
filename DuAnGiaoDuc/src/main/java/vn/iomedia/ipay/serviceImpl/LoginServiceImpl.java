package vn.iomedia.ipay.serviceImpl;

import javax.persistence.EntityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.LoginService;

public class LoginServiceImpl implements LoginService {

    private EntityManager em = SQLConnection.getConnection();
    private Log log = LogFactory.getLog(LoginServiceImpl.class);

    @Override
    public Student getStudentByIdCardAndPass(String idCard, String password) {
        try {
            Student student = (Student) em
                    .createQuery("select u from Student u where u.idCard = :idCard and u.password = :password")
                    .setParameter("idCard", idCard).setParameter("password", password).getSingleResult();
            return student;
        } catch (Exception exp) {
            log.error(exp.getMessage());
            return null;
        } finally {
        }
    }

}
