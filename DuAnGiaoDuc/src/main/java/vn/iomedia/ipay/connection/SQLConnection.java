package vn.iomedia.ipay.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

public class SQLConnection {

    private static Logger log = Logger.getLogger(SQLConnection.class);
    private static EntityManager em;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("tuyensinh");

    public static EntityManager getConnection() {
        try {
            if (em == null || !em.isOpen()) {
                em = emf.createEntityManager();
            }
            return em;
        } catch (Exception exp) {
            log.error(exp.getMessage());
            return em;
        }
    }

    public static void closeConnection() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

}
