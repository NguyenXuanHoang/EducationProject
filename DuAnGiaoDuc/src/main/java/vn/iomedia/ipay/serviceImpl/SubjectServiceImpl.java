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
            GroupSubjects school = (GroupSubjects) em
                    .createQuery("select sch from GroupSubjects sch where sch.id = :id").setParameter("id", id)
                    .getSingleResult();
            return school;
        } catch (NoResultException e) {
            log.error(e.getMessage());
            return null;
        } finally {
        }
    }

}
