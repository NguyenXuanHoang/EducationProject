package vn.iomedia.ipay.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.GroupSubjects;
import vn.iomedia.ipay.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

    private Log log = LogFactory.getLog(SubjectServiceImpl.class);
    private EntityManager em = SQLConnection.getConnection();

    @Override
    public GroupSubjects getSubjectById(int id) {
        try {
            log.debug("get Group Subject by shcool Id");
            GroupSubjects school = (GroupSubjects) em
                    .createQuery("SELECT sch FROM GroupSubjects sch WHERE sch.id = :id").setParameter("id", id)
                    .getSingleResult();
            return school;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        } finally {
        }
    }

}
