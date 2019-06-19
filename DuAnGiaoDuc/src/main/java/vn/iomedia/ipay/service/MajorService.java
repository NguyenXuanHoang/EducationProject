package vn.iomedia.ipay.service;

import java.util.List;

import vn.iomedia.ipay.entity.Majors;

public interface MajorService {

    public Majors getMajorById(int id);
    public List<Majors> getListMajorBySchoolId(int schoolId);
    
}
