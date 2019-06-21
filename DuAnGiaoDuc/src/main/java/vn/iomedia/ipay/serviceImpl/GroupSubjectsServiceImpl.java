package vn.iomedia.ipay.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.GroupSubjects;
import vn.iomedia.ipay.service.GroupSubjectService;

public class GroupSubjectsServiceImpl implements GroupSubjectService {

    private Log log = LogFactory.getLog(GroupSubjectsServiceImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public List<GroupSubjects> getListSubjectByMajorId(int majorId) {
        EntityManager em = SQLConnection.getConnection();
        try {
            log.debug("get List group subject by major id.");
            List<GroupSubjects> subjects = em.createQuery(
                    "SELECT sb FROM GroupSubjects sb join MajorGroupSubject msj on sb.id = msj.groupsSubject.id WHERE msj.major.id = :major_id")
                    .setParameter("major_id", majorId).getResultList();
            return subjects;
        } catch (Exception exp) {
            log.error(exp.getMessage());
            return null;
        } finally {
            SQLConnection.closeConnection();
        }

    }

}
