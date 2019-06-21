package vn.iomedia.ipay.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.microsoft.sqlserver.jdbc.StringUtils;

import vn.iomedia.ipay.Contanst.CommonContanst;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.StudentService;
import vn.iomedia.ipay.serviceImpl.StudentServiceImpl;
import vn.iomedia.ipay.utils.ObjectUtils;

@ManagedBean(name = "changePass")
@ViewScoped
public class ChangePass implements Serializable {

    private static final long serialVersionUID = 8765845877376608394L;
    private Log log = LogFactory.getLog(ChangePass.class);

    private String oldPass;
    private String newPass;
    private String newPass2;
    private Student student;
    private StudentService service = new StudentServiceImpl();

    @PostConstruct
    public void init() {
        try {
            log.debug("Get Student from Context in changePass page.");
            this.student = (Student) ObjectUtils.getObjectByString(CommonContanst.STUDENT);
        } catch (Exception exp) {
            log.error(exp.getMessage());
        }
    }

    public String submit() {
        if (!student.getPassword().equals(oldPass)) {
            log.debug("if oldPass not equal with current Pass,return fail");
            return CommonContanst.FAIL;
        }

        if (!StringUtils.isEmpty(newPass) && !StringUtils.isEmpty(newPass2) && newPass.equals(newPass2)) {
            log.debug("Save new pass to Student and return success.");
            service.updatePass(student, newPass);
            return CommonContanst.SUCCESS;
        }
        return CommonContanst.FAIL;
    }

    /**
     * @return the oldPass
     */
    public String getOldPass() {
        return oldPass;
    }

    /**
     * @param oldPass
     *            the oldPass to set
     */
    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    /**
     * @return the newPass
     */
    public String getNewPass() {
        return newPass;
    }

    /**
     * @param newPass
     *            the newPass to set
     */
    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    /**
     * @return the newPass2
     */
    public String getNewPass2() {
        return newPass2;
    }

    /**
     * @param newPass2
     *            the newPass2 to set
     */
    public void setNewPass2(String newPass2) {
        this.newPass2 = newPass2;
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
