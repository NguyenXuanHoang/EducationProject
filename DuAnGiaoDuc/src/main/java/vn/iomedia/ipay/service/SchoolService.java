package vn.iomedia.ipay.service;

import java.util.List;

import vn.iomedia.ipay.entity.School;

public interface SchoolService {
    
    List<School> searchListSchoolByName(String name);
    
    List<School> getSchoolsByGroupId(int groupId);

    School getSchoolById(int id);
}
