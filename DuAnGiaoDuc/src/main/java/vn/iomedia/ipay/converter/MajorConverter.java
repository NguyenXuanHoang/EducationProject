package vn.iomedia.ipay.converter;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import vn.iomedia.ipay.entity.Majors;
import vn.iomedia.ipay.service.MajorService;
import vn.iomedia.ipay.serviceImpl.MajorServiceImpl;

@ManagedBean(name = "majorConverterBean")
@FacesConverter(value = "majorConverter")
public class MajorConverter implements Converter, Serializable {
    private static final long serialVersionUID = 7053414108213420057L;
    private Log log = LogFactory.getLog(MajorConverter.class);
    private MajorService service = new MajorServiceImpl();
 

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        log.debug("convert to Object " + value);
        if (value != null) {
            return service.getMajorById(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
         if (modelValue == null) {
            return "";
        }
        if (modelValue instanceof Majors) {
            return String.valueOf(((Majors) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid Warehouse"));
        }
    }

}