package vn.iomedia.ipay.serviceImpl;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.GroupSchool;
import vn.iomedia.ipay.service.GroupSchoolService;

public class GroupSchoolServiceImpl implements GroupSchoolService {

    private Logger log = Logger.getLogger(GroupSchoolServiceImpl.class);

    @Override
    public GroupSchool getGroupSchoolBySchoolId(int schoolId) {
        EntityManager em = SQLConnection.getConnection();
        try {
            log.debug("Get Group School By School Id.");
            GroupSchool groupSchool = (GroupSchool) em.createQuery(
                    "SELECT grsch FROM GroupSchool grsch join School s on s.groupSchool.id = grsch.id WHERE s.id = :id")
                    .setParameter("id", schoolId).getSingleResult();
            return groupSchool;
        } catch (Exception exp) {
            log.error(exp.getMessage());
            return null;
        } finally {
            SQLConnection.closeConnection();
        }
    }

}
