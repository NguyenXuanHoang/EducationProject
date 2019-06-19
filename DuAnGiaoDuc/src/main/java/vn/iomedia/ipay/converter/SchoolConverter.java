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

import vn.iomedia.ipay.entity.School;
import vn.iomedia.ipay.service.SchoolService;
import vn.iomedia.ipay.serviceImpl.SchoolServiceImpl;

@ManagedBean(name = "schoolConverterBean")
@FacesConverter(value = "schoolConverter")
public class SchoolConverter implements Converter, Serializable {

    private static final long serialVersionUID = 7053414108213420057L;
    private Log log = LogFactory.getLog(SchoolConverter.class);
    private SchoolService service = new SchoolServiceImpl();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        log.debug("convert to Object " + value);
        return service.getSchoolById(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }
        if (modelValue instanceof School) {
            return String.valueOf(((School) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid Warehouse"));
        }
    }

}