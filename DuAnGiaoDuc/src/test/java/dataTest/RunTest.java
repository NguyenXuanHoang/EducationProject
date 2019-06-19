package dataTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import vn.iomedia.ipay.connection.SQLConnection;

public class RunTest {

	static EntityManager em = SQLConnection.getConnection();
	static EntityTransaction transaction = em.getTransaction();
	
	public static void main(String[] args) {
		InsertExamation.insertEximation(em,transaction);
		InsertStudent.insertStudent1(em,transaction);
		InsertSchool.insertSchool(em,transaction);
	}
}
