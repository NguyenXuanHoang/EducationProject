package vn.iomedia.ipay.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import vn.iomedia.ipay.connection.SQLConnection;
import vn.iomedia.ipay.entity.Mark;
import vn.iomedia.ipay.entity.PriorityArea;
import vn.iomedia.ipay.entity.PriorityObject;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.LoginService;

public class LoginServiceImpl implements LoginService {
    EntityManager em = SQLConnection.getConnection();
    EntityTransaction transaction = em.getTransaction();

    public Student validateLogin(String idCard, String password) {
        if ("1".equalsIgnoreCase(idCard) && "1".equalsIgnoreCase(password)) {
            Student stu = new Student();
            stu.setAddress("test Address");
            stu.setDob("15/03/1986");
            stu.setIdCard("123");
            stu.setIdNumber("12345");
            stu.setFirstName("Nguyen");
            stu.setLastName("Giao");
            PriorityArea par = new PriorityArea();
            par.setCodeArea("125");
            stu.setPriorityArea(par);
            PriorityObject pob = new PriorityObject();
            pob.setCodeObject("5");
            stu.setPriorityObject(pob);
            Mark mar = new Mark();
            mar.setChemistry(5.25);
            mar.setEnglish(8.0);
            mar.setLiterature(5.4);
            mar.setMath(7.5);
            mar.setPhysical(8.5);
            stu.setMark(mar);
            return stu;
        }
        return null;
    }

    @Override
    public Student getStudentByIdCardAndPass(String idCard, String password) {
        try {
            Student student = (Student) em
                    .createQuery("select u from Student u where u.idCard = :idCard and u.password = :password")
                    .setParameter("idCard", idCard).setParameter("password", password).getSingleResult();
            return student;
        } catch (NoResultException e) {
            System.out.println(e.getMessage().toString());
            return null;
        } finally {
//            SQLConnection.closeConnection(em);
        }
    }

}
