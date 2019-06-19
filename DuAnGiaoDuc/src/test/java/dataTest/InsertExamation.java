package dataTest;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import vn.iomedia.ipay.entity.Examination;

public class InsertExamation {

	@SuppressWarnings("deprecation")
	public static void insertEximation(EntityManager em, EntityTransaction transaction) {
		transaction.begin();

		Examination ex1 = new Examination();
		ex1.setAdmissions(1);
		ex1.setTimeAdmissions(30);
		ex1.setBeginAdmissions(new Date(119, 5, 1));
		ex1.setEndAdmissions(new Date(119, 5, 30));
		ex1.setGroupSchoolNumber(4);
		ex1.setSingleSchoolNumber(2);
		em.persist(ex1);

		Examination ex2 = new Examination();
		ex2.setAdmissions(2);
		ex2.setTimeAdmissions(15);
		ex2.setBeginAdmissions(new Date(119, 6, 1));
		ex2.setEndAdmissions(new Date(119, 6, 15));
		ex2.setGroupSchoolNumber(6);
		ex2.setSingleSchoolNumber(3);
		em.persist(ex2);

		Examination ex3 = new Examination();
		ex3.setAdmissions(3);
		ex3.setTimeAdmissions(20);
		ex3.setBeginAdmissions(new Date(119, 7, 1));
		ex3.setEndAdmissions(new Date(119, 7, 20));
		ex3.setGroupSchoolNumber(6);
		ex3.setSingleSchoolNumber(3);
		em.persist(ex3);

		transaction.commit();

	}

}
