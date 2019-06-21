package vn.iomedia.ipay.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.Majors;
import vn.iomedia.ipay.service.MajorService;

public class MajorServiceImpl implements MajorService {

    private Log log = LogFactory.getLog(MajorServiceImpl.class);
    private EntityManager em = SQLConnection.getConnection();

    @Override
    public Majors getMajorById(int id) {
        try {
            log.debug("get Major by Id.");
            Majors major = (Majors) em.createQuery("SELECT mj from Majors mj WHERE mj.id = :id").setParameter("id", id)
                    .getSingleResult();
            return major;
        } catch (Exception exp) {
            log.error(exp.getMessage());
            return null;
        } finally {
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Majors> getListMajorBySchoolId(int schoolId) {
        try {
            log.debug("Get list Major by School id.");
            List<Majors> majors = em.createQuery("SELECT m from Majors m WHERE m.school.id = :school_fk")
                    .setParameter("school_fk", schoolId).getResultList();
            return majors;
        } catch (NoResultException e) {
            log.error(e.getMessage());
            return null;
        } finally {
            SQLConnection.closeConnection();
        }

    }

}
