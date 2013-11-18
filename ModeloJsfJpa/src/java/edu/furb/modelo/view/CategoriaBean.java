package edu.furb.modelo.view;

import edu.furb.modelo.model.Categoria;
import edu.furb.modelo.persistence.JpaUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

@ManagedBean
public class CategoriaBean {

    private List<Categoria> list;
    private Categoria bean = new Categoria();

    public List<Categoria> getList() {
        if (list == null) {
            EntityManager em = JpaUtil.getEntityManager();
            list = em.createQuery("SELECT o FROM Categoria AS o "
                    + " ORDER BY o.nome",
                    Categoria.class).getResultList();
        }
        return list;
    }

    public Categoria getBean() {
        return bean;
    }

    public String editar(Categoria parametro) {
        bean = parametro;
        return "";
    }
    
    public String excluir(Categoria parametro) {
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
        return "";
    }
}
