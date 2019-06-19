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

    EntityManager em = SQLConnection.getConnection();

    @Override
    public Majors getMajorById(int id) {
        try {
            Majors major = (Majors) em.createQuery("select mj from Majors mj where mj.id = :id").setParameter("id", id)
                    .getSingleResult();
            return major;
        } catch (NoResultException e) {
            log.error(e.getMessage());
            return null;
        } finally {
        }
    }

    @Override
    public List<Majors> getListMajorBySchoolId(int schoolId) {
        try {
            @SuppressWarnings("unchecked")
            List<Majors> majors = em.createQuery("select m from Majors m where m.school.id = :school_fk")
                    // .createQuery("select m from Majors m join School s on m.school = s where s.id
                    // = :school_fk")
                    .setParameter("school_fk", schoolId).getResultList();
            return majors;
        } catch (NoResultException e) {
            log.error(e.getMessage());
            return null;
        } finally {
        }

    }

}
