package vn.iomedia.ipay.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.GroupSchool;
import vn.iomedia.ipay.service.GroupSchoolService;

public class GroupSchoolServiceImpl implements GroupSchoolService {

	private Log log = LogFactory.getLog(SchoolServiceImpl.class);
	EntityManager em = SQLConnection.getConnection();

	@Override
	public GroupSchool getGroupSchoolBySchoolId(int schoolId) {
		try {
			GroupSchool groupSchool = (GroupSchool) em.createQuery(
					"select grsch from GroupSchool grsch join School s on s.groupSchool.id = grsch.id where s.id = :id")
					.setParameter("id", schoolId).getSingleResult();
			return groupSchool;
		} catch (NoResultException e) {
			log.error(e.getMessage());
			return null;
		} finally {
		}
	}

}
