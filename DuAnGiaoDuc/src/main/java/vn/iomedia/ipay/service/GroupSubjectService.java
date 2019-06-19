package vn.iomedia.ipay.service;

import java.util.List;

import vn.iomedia.ipay.entity.GroupSubjects;

public interface GroupSubjectService {
	List<GroupSubjects> getListSubjectByMajorId(int majorId);
}
