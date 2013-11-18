package edu.furb.modelo.view.converter;

import edu.furb.modelo.model.Categoria;
import edu.furb.modelo.persistence.JpaUtil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author senai-sc
 */
@FacesConverter(forClass=Categoria.class)
public class CategoriaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return JpaUtil.getEntityManager().
                find(Categoria.class, Long.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return String.valueOf(((Categoria)o).getId());
    }
    
}
