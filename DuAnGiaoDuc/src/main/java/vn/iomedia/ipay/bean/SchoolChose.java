package vn.iomedia.ipay.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.microsoft.sqlserver.jdbc.StringUtils;

import vn.iomedia.ipay.Contanst.CommonContanst;
import vn.iomedia.ipay.entity.GroupSchool;
import vn.iomedia.ipay.entity.School;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.GroupSchoolService;
import vn.iomedia.ipay.service.SchoolService;
import vn.iomedia.ipay.serviceImpl.GroupSchoolServiceImpl;
import vn.iomedia.ipay.serviceImpl.SchoolServiceImpl;
import vn.iomedia.ipay.utils.ObjectUtils;

@ManagedBean(name = "schoolChose", eager = true)
@ViewScoped
public class SchoolChose implements Serializable {

    private static final long serialVersionUID = -4554613380514861507L;
    private Log log = LogFactory.getLog(SchoolChose.class);

    private Student student;
    private String schoolName;
    private List<School> schools;
    private List<School> schoolsSelect;
    private School sch;

    private SchoolService schoolService = new SchoolServiceImpl();
    private GroupSchoolService groupSchoolService = new GroupSchoolServiceImpl();

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        try {
            log.debug("get Studentfrom Context in School Chose page");
            this.student = (Student) ObjectUtils.getObjectByString(CommonContanst.STUDENT);
            schools = new ArrayList<>();
            schools.addAll((List<School>) ObjectUtils.getObjectByString(CommonContanst.LIST_SCHOOL));
        } catch (Exception exp) {
            log.error(exp.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void search() {
        if (StringUtils.isEmpty(schoolName)) {
            log.debug("add all list school.");
            schools.removeAll(schools);
            schools.addAll((List<School>) ObjectUtils.getObjectByString(CommonContanst.LIST_SCHOOL));
        } else {
            log.debug("add list group school.");
            List<School> schs = (List<School>) ObjectUtils.getObjectByString(CommonContanst.LIST_SCHOOL);
            schools = new ArrayList<>();
            schs.forEach(sch -> {
                if (sch != null && sch.getName().contains(schoolName)) {
                    schools.add(sch);
                }
            });
        }

    }

    public String choseMajor() {
        if (student == null) {
            log.debug("If student == null return to Main Page");
            return CommonContanst.FAIL;
        }
        if (sch != null) {
            List<School> schoolChose = new ArrayList<>();
            log.debug("User chose 1 data ,now search list school same ");
            GroupSchool group = groupSchoolService.getGroupSchoolBySchoolId(sch.getId());
            if (CommonContanst.GROUP_INT_2 == group.getNumberChose()) {
                schoolChose.add(sch);
            } else {
                schoolChose = schoolService.getSchoolsByGroupId(group.getId());
            }
            if (!CollectionUtils.isEmpty(schoolChose) && group != null) {
                log.debug("User chosse list school,send to Chose Major.");
                ObjectUtils.putObjectContext(CommonContanst.LIST_SCHOOL, schoolChose);
                ObjectUtils.putObjectContext(CommonContanst.GROUP_SCHOOL, group);
                ObjectUtils.putObjectContext(CommonContanst.SCHOOL, sch);
                if (group.getNumberChose() == CommonContanst.GROUP_INT_4) {
                    return CommonContanst.GROUP_4;
                } else if (group.getNumberChose() == CommonContanst.GROUP_INT_2) {
                    return CommonContanst.GROUP_2;
                }
            }
        }
        log.debug("If chose data = null retry this Page");
        return CommonContanst.RETRY;
    }

    /**
     * @return the sch
     */
    public School getSch() {
        return sch;
    }

    /**
     * @param sch
     *            the sch to set
     */
    public void setSch(School sch) {
        this.sch = sch;
    }

    /**
     * @return the schoolsSelect
     */
    public List<School> getSchoolsSelect() {
        return schoolsSelect;
    }

    /**
     * @param schoolsSelect
     *            the schoolsSelect to set
     */
    public void setSchoolsSelect(List<School> schoolsSelect) {
        this.schoolsSelect = schoolsSelect;
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
     * @return the schoolName
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * @param schoolName
     *            the schoolName to set
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * @return the schools
     */
    public List<School> getSchools() {
        return schools;
    }

    /**
     * @param schools
     *            the schools to set
     */
    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

}
