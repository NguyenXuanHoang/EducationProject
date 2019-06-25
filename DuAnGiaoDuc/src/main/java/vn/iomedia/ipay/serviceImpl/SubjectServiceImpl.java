package vn.iomedia.ipay.serviceImpl;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.GroupSubjects;
import vn.iomedia.ipay.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

    private Logger log = Logger.getLogger(SubjectServiceImpl.class);

    @Override
    public GroupSubjects getSubjectById(int id) {
        EntityManager em = SQLConnection.getConnection();
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
            SQLConnection.closeConnection();
        }
    }

}
