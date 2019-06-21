package vn.iomedia.ipay.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.microsoft.sqlserver.jdbc.StringUtils;

import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.School;
import vn.iomedia.ipay.service.SchoolService;

public class SchoolServiceImpl implements SchoolService {

    private Log log = LogFactory.getLog(SchoolServiceImpl.class);
    EntityManager em = SQLConnection.getConnection();

    @Override
    public List<School> searchListSchoolByName(String name) {
        if (StringUtils.isEmpty(name)) {
            log.debug("if name = null,then get all list of school.");
            try {
                @SuppressWarnings("unchecked")
                List<School> schools = em.createQuery("SELECT sch FROM School sch").getResultList();
                return schools;
            } catch (NoResultException e) {
                log.error(e.getMessage());
                return null;
            } finally {
            }
        }
        log.debug("if name not null,then search school by name");
        try {
            @SuppressWarnings("unchecked")
            List<School> schools = em
                    .createQuery("SELECT sch FROM School sch WHERE sch.name LIKE CONCAT('%',:name,'%')")
                    .setParameter("name", name).getResultList();
            return schools;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        } finally {
            SQLConnection.closeConnection();
        }

    }

    @Override
    public School getSchoolById(int id) {
        try {
            log.debug("get school by Id.");
            School school = (School) em.createQuery("SELECT sch FROM School sch WHERE sch.id = :id")
                    .setParameter("id", id).getSingleResult();
            return school;
        } catch (NoResultException e) {
            log.error(e.getMessage());
            return null;
        } finally {
            SQLConnection.closeConnection();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<School> getSchoolsByGroupId(int groupId) {
        try {
            List<School> schools = em.createQuery("SELECT sch FROM School sch WHERE sch.groupSchool.id = :id")
                    .setParameter("id", groupId).getResultList();
            return schools;
        } catch (NoResultException e) {
            log.error(e.getMessage());
            return null;
        } finally {
            SQLConnection.closeConnection();
        }
    }

}
