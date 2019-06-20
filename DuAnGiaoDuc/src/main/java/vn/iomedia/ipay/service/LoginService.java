package vn.iomedia.ipay.service;

import vn.iomedia.ipay.entity.Student;

public interface LoginService {

    Student getStudentByIdCardAndPass(String idCard, String password);
}
