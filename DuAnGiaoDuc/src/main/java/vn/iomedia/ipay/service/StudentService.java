package vn.iomedia.ipay.service;

import vn.iomedia.ipay.entity.Student;

public interface StudentService {

    void updatePass(Student student, String newPass);

    void updateNumberAndDateRegis(Student student, int number);

}
