package br.edu.ifro.util;

import br.edu.ifro.model.Disciplina;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//@author Gabriel Pedrosa
public class Disciplinas {
    
    public Disciplinas() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT count(d) FROM Disciplina as d");
        long result = (long) query.getSingleResult();
        if (result == 0) {
            String[] disciplina = {"Português", "Matemática"};
            String[] cargahoraria = {"200", "300"};
            for (int i = 0; i < disciplina.length; i++){
            Disciplina d = new Disciplina();
            
            d.setDis_nome(disciplina[i]);
            d.setDis_cargahoraria(cargahoraria[i]);

            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
            
            }
        }
        em.close();
        emf.close();
    }   
}
