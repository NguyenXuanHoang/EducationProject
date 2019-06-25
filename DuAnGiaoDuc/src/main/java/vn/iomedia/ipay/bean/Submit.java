package vn.iomedia.ipay.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.apache.log4j.Logger;

import com.microsoft.sqlserver.jdbc.StringUtils;

import vn.iomedia.ipay.Contanst.CommonContanst;
import vn.iomedia.ipay.entity.RegistrationDetail;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.utils.ObjectUtils;

@ManagedBean(name = "submit")
@ViewScoped
public class Submit implements Serializable {

    private static final long serialVersionUID = -39199585621294241L;
    private Logger log = Logger.getLogger(Submit.class);
    private Student student;
    private List<RegistrationDetail> listDetail;
    private String otpInput;
    private String otpOutput;

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        try {
            log.debug("get Student,listDetail,OTP from Context in submit page");
            this.student = (Student) ObjectUtils.getObjectByString(CommonContanst.STUDENT);
            this.listDetail = (List<RegistrationDetail>) ObjectUtils.getObjectByString(CommonContanst.LIST_DETAIL);
            this.otpOutput = (String) ObjectUtils.getObjectByString(CommonContanst.OTP);
        } catch (Exception exp) {
            log.error(exp.getMessage());
        }
    }

    public String submit() {
        if (!StringUtils.isEmpty(otpInput) && otpOutput.equals(otpInput)) {
            return CommonContanst.SUCCESS;
        }
        return CommonContanst.FAIL;
    }

    public String turnBack() {
        return CommonContanst.SUCCESS;
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

    /**
     * @return the otpInput
     */
    public String getOtpInput() {
        return otpInput;
    }

    /**
     * @param otpInput
     *            the otpInput to set
     */
    public void setOtpInput(String otpInput) {
        this.otpInput = otpInput;
    }

    /**
     * @return the otpOutput
     */
    public String getOtpOutput() {
        return otpOutput;
    }

    /**
     * @param otpOutput
     *            the otpOutput to set
     */
    public void setOtpOutput(String otpOutput) {
        this.otpOutput = otpOutput;
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

}
