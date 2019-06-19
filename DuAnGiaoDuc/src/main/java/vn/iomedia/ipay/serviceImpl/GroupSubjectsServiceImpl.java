package vn.iomedia.ipay.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.GroupSubjects;
import vn.iomedia.ipay.service.GroupSubjectService;

public class GroupSubjectsServiceImpl implements GroupSubjectService {

	private Log log = LogFactory.getLog(GroupSubjectsServiceImpl.class);

	EntityManager em = SQLConnection.getConnection();

	@Override
	public List<GroupSubjects> getListSubjectByMajorId(int majorId) {
		try {
			@SuppressWarnings("unchecked")
			List<GroupSubjects> subjects = em.createQuery(
					"select sb from GroupSubjects sb join MajorGroupSubject msj on sb.id = msj.groupsSubject.id where msj.major.id = :major_id")
					.setParameter("major_id", majorId).getResultList();
			return subjects;
		} catch (NoResultException e) {
			log.error(e.getMessage());
			return null;
		} finally {
		}

	}

}
