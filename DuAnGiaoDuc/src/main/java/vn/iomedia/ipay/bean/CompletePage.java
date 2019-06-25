package vn.iomedia.ipay.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import vn.iomedia.ipay.Contanst.CommonContanst;
import vn.iomedia.ipay.entity.RegistrationDetail;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.RegAdmissionService;
import vn.iomedia.ipay.serviceImpl.RegAdmissionServiceImpl;
import vn.iomedia.ipay.utils.ObjectUtils;

@ManagedBean(name = "complete")
@ViewScoped
public class CompletePage implements Serializable {

    private static final long serialVersionUID = -39199585621294241L;
    private Logger log = Logger.getLogger(CompletePage.class);
    private Student student;
    private List<RegistrationDetail> listDetail;

    private RegAdmissionService regService = new RegAdmissionServiceImpl();

    @PostConstruct
    public void init() {
        try {
            log.debug("Get student from Context in Complete Page");
            this.student = (Student) ObjectUtils.getObjectByString(CommonContanst.STUDENT);
            if (student != null) {
                log.debug("if student not null,get Registration Detail.");
                this.listDetail = regService.getListRegistrationByStudentId(student.getId());
            }
        } catch (Exception exp) {
            log.error(exp.getMessage());
        }
    }

    /**
     * @return the student
     */
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
