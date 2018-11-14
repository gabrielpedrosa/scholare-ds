package br.edu.ifro.util;

import br.edu.ifro.model.Funcionario;
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
        
        Query query = em.createQuery("SELECT count(f) FROM Funcionario as f");
        long result = (long) query.getSingleResult();
        if (result == 0) {
            Funcionario f = new Funcionario();
            
            f.setLog_usuario("admin");
            f.setLog_senha("admin");

            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        }
    }
    
    
}
