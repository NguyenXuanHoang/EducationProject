package vn.iomedia.ipay.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import vn.iomedia.ipay.contanst.CommonContanst;
import vn.iomedia.ipay.entity.School;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.SchoolService;
import vn.iomedia.ipay.serviceImpl.SchoolServiceImpl;
import vn.iomedia.ipay.utils.ObjectUtils;

@ManagedBean
@ViewScoped
public class RegisterAdmission implements Serializable {

    private static final long serialVersionUID = 8556089000353339935L;
    private Logger log = Logger.getLogger(RegisterAdmission.class);
    private SchoolService schoolService = new SchoolServiceImpl();
    private Student student;

    @PostConstruct
    public void init() {
        try {
            log.debug("get Studentfrom Context in Registration Admission page");
            this.student = (Student) ObjectUtils.getObjectByString(CommonContanst.STUDENT);
        } catch (Exception exp) {
            log.error(exp.getMessage());
        }
    }

    public String choseSchool() {
        if (student != null && student.getNumberRegis() == 0) {
            log.debug("Student do not have change for register,return.");
            return CommonContanst.RETURN;
        }
        if (student != null && student.getNumberRegis() >= 1) {
            log.debug("if student still have registration then continue.");
            List<School> listSchool = schoolService.searchListSchoolByName(null);
            if (!CollectionUtils.isEmpty(listSchool)) {
                ObjectUtils.putObjectContext(CommonContanst.LIST_SCHOOL, listSchool);
            }
            log.debug("if student not null,go to Chose School.");
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

}
