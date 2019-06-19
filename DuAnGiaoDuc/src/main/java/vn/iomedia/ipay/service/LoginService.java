package vn.iomedia.ipay.service;

import vn.iomedia.ipay.entity.Student;

public interface LoginService {

    Student validateLogin(String idCard, String password);

    Student getStudentByIdCardAndPass(String idCard, String password);
}
