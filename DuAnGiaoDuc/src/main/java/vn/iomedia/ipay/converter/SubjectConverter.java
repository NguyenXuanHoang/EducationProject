package vn.iomedia.ipay.converter;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import vn.iomedia.ipay.entity.GroupSubjects;
import vn.iomedia.ipay.service.SubjectService;
import vn.iomedia.ipay.serviceImpl.SubjectServiceImpl;

@ManagedBean(name = "subjectConverterBean")
@FacesConverter(value = "subjectConverter")
public class SubjectConverter implements Converter, Serializable {
    private static final long serialVersionUID = 7053414108213420057L;
    private Logger log = Logger.getLogger(SubjectConverter.class);
    private SubjectService service = new SubjectServiceImpl();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        log.debug("convert to Object " + value);
        if (value != null) {
            return service.getSubjectById(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }
        if (modelValue instanceof GroupSubjects) {
            return String.valueOf(((GroupSubjects) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid Warehouse"));
        }
    }

}