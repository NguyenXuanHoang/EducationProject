package vn.iomedia.ipay.service;

import java.util.List;

import vn.iomedia.ipay.entity.RegistrationDetail;

public interface RegAdmissionService {

    List<RegistrationDetail> getListRegistrationByStudentId(int studentId);
}
