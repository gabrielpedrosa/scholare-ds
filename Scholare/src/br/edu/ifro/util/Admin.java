package br.edu.ifro.util;

import br.edu.ifro.model.Funcionario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//@author Gabriel Pedrosa
public class Admin {

    public Admin() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT count(f) FROM Funcionario as f");
        long result = (long) query.getSingleResult();
        if (result == 0) {
            Funcionario f = new Funcionario();
            
            f.setFun_nome("admin");
            f.setFun_sexo("admin");
            f.setFun_cpf("admin");
            f.setFun_rg("admin");
            f.setFun_telefone("admin");
            f.setFun_nascimento("admin");
            f.setFun_funcao("admin");
            f.setFun_logradouro("admin");
            f.setFun_bairro("admin");
            f.setFun_numero("admin");
            f.setFun_cidade("admin");
            f.setFun_estado("admin");
            f.setFun_email("admin");
            f.setLog_usuario("admin");
            f.setLog_senha("admin");
            f.setLog_pergunta("admin");
            f.setLog_resposta("admin");
            f.setLog_usuario("admin");
            f.setLog_senha("admin");
            f.setFun_datacadastro("admin");

            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            em.close();
            emf.close();
        }
    }
}
