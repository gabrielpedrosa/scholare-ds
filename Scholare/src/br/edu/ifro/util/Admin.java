package br.edu.ifro.util;

import br.edu.ifro.model.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Gabriel
 */
public class Admin {

    public Admin() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT count(l) FROM Login as l");
        long result = (long) query.getSingleResult();
        if (result == 0) {
            Login login = new Login();
            
            login.setLog_usuario("admin");
            login.setLog_senha("admin");

            em.getTransaction().begin();
            em.persist(login);
            em.getTransaction().commit();
        }
    }
    
    
}
