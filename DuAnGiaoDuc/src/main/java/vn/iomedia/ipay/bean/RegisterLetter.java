package vn.iomedia.ipay.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import vn.iomedia.ipay.Contanst.CommonContanst;
import vn.iomedia.ipay.entity.RegistrationDetail;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.RegAdmissionService;
import vn.iomedia.ipay.serviceImpl.RegAdmissionServiceImpl;
import vn.iomedia.ipay.utils.ObjectUtils;

@ManagedBean
@ViewScoped
public class RegisterLetter implements Serializable {

    private static final long serialVersionUID = 8556089000353339935L;
    private Log log = LogFactory.getLog(RegAdmissionService.class);
    private RegAdmissionService regService = new RegAdmissionServiceImpl();
    private Student student;
    private List<RegistrationDetail> listDetail;

    @PostConstruct
    public void init() {
        try {
            log.debug("get Student,listDetail from Context in registration page");
            this.student = (Student) ObjectUtils.getObjectByString(CommonContanst.STUDENT);
            if (student != null) {
                log.debug("if student not null,get Registration Detail.");
                this.listDetail = regService.getListRegistrationByStudentId(student.getId());
            }
        } catch (Exception exp) {
            log.error(exp.getMessage());
        }
    }

    public String choseRegis() {
        if (student != null) {
            log.debug("if student not null,go to Chose Register.");
            return CommonContanst.SUCCESS;
        }
        log.debug("if student null,go to Main Page.");
        return CommonContanst.FAIL;
    }

    public Student getStudent() {
        return student;
    }

    /**
     * @param student
     *            the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the listDetail
     */
    public List<RegistrationDetail> getListDetail() {
        return listDetail;
    }

    /**
     * @param listDetail
     *            the listDetail to set
     */
    public void setListDetail(List<RegistrationDetail> listDetail) {
        this.listDetail = listDetail;
    }

}
