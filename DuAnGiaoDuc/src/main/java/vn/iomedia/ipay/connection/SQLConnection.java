package vn.iomedia.ipay.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SQLConnection {

    public static EntityManager getConnection() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tuyensinh");
        
        EntityManager em = emf.createEntityManager();
        return em;
    }

//    public static void closeConnection(EntityManager em) {
//        if (em != null) {
//            em.close();
//        }
//    }
}
