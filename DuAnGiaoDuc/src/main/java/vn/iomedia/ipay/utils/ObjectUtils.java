package vn.iomedia.ipay.utils;

import javax.faces.context.FacesContext;

public class ObjectUtils {

    public static Object getObjectByString(String name) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getExternalContext().getSessionMap().get(name);
    }

    public static void putObjectContext(String name, Object ob) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put(name, ob);
    };
}
