package vn.iomedia.ipay.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SQLConnection {

    private static Log log = LogFactory.getLog(SQLConnection.class);

    public static EntityManager getConnection() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("tuyensinh");
            EntityManager em = emf.createEntityManager();
            return em;
        } catch (Exception exp) {
            log.error(exp.getMessage());
            return null;
        }
    }

}
