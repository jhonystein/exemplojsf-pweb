package edu.furb.modelo.view;

import edu.furb.modelo.model.Contato;
import edu.furb.modelo.persistence.JpaUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

@ManagedBean(name = "contatoMB")
public class ContatoBean {

    private List<Contato> list;
    private Contato bean = new Contato();

    public List<Contato> getList() {
        if (list == null) {
            EntityManager em = JpaUtil.getEntityManager();
            list = em.createQuery("SELECT o FROM Contato AS o "
                    + " ORDER BY o.nome",
                    Contato.class).getResultList();
        }
        return list;
    }

    public Contato getBean() {
        return bean;
    }

    public String editar(Contato parametro) {
        bean = parametro;
        return "form";
    }
    
    public String excluir(Contato parametro) {
        EntityManager em = JpaUtil.getEntityManager();
        em.merge(parametro);
        em.remove(parametro);
        list = null;
        return null;
    }
    
    public String salvar() {
        EntityManager em = JpaUtil.getEntityManager();
        if (bean.getId() == 0) {
            em.persist(bean);
        } else {
            em.merge(bean);
        }
        list = null;
        return "index";
    }
}
