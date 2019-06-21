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
import vn.iomedia.ipay.email.SendEmail;
import vn.iomedia.ipay.entity.GroupSubjects;
import vn.iomedia.ipay.entity.Majors;
import vn.iomedia.ipay.entity.RegistrationDetail;
import vn.iomedia.ipay.entity.School;
import vn.iomedia.ipay.entity.Student;
import vn.iomedia.ipay.service.GroupSubjectService;
import vn.iomedia.ipay.service.MajorService;
import vn.iomedia.ipay.serviceImpl.GroupSubjectsServiceImpl;
import vn.iomedia.ipay.serviceImpl.MajorServiceImpl;
import vn.iomedia.ipay.utils.ObjectUtils;
import vn.iomedia.ipay.utils.StringUtillStudy;

@ManagedBean(name = "major2Chose", eager = true)
@ViewScoped
public class Major2Chose implements Serializable {

    private static final long serialVersionUID = -4057556628266352443L;
    private Log log = LogFactory.getLog(Major4Chose.class);

    private Student student;
    private List<School> schoolsSelect;
    private List<RegistrationDetail> listDetail;
    private School schChose;

    private List<Majors> majors1;
    private List<GroupSubjects> grpSj1;

    private Majors major1;
    private GroupSubjects sub1;
    private String totalMark1;

    private List<Majors> majors2;
    private List<GroupSubjects> grpSj2;
    private Majors major2;
    private GroupSubjects sub2;
    private String totalMark2;

    private MajorService majorService = new MajorServiceImpl();
    private GroupSubjectService subService = new GroupSubjectsServiceImpl();

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        try {
            log.debug("get Student,listSchool,schoolSelect from Context in Major2chose page");
            this.student = (Student) ObjectUtils.getObjectByString(CommonContanst.STUDENT);
            this.schoolsSelect = (List<School>) ObjectUtils.getObjectByString(CommonContanst.LIST_SCHOOL);
            if (!CollectionUtils.isEmpty(schoolsSelect) && schoolsSelect.size()==1) {
                log.debug("Set school ,major default.");
                this.schChose = schoolsSelect.get(0);
                this.majors1 = majorService.getListMajorBySchoolId(schoolsSelect.get(0).getId());
                if (!CollectionUtils.isEmpty(majors1)) {
                    this.grpSj1 = subService.getListSubjectByMajorId(majors1.get(0).getId());
                }
                this.majors2 = majorService.getListMajorBySchoolId(schoolsSelect.get(0).getId());
                if (!CollectionUtils.isEmpty(majors1)) {
                    this.grpSj2 = subService.getListSubjectByMajorId(majors2.get(0).getId());

                }
            }
        } catch (Exception exp) {
            log.error(exp.getMessage());
        }
    }

    public void searchMajor1() {
        if (schChose != null) {
            this.majors1 = majorService.getListMajorBySchoolId(schChose.getId());
        }
    }

    public void searchMajor2() {
        if (schChose != null) {
            majors2 = majorService.getListMajorBySchoolId(schChose.getId());
        }
    }

    public void searchSubject1() {
        grpSj1 = new ArrayList<>();
        if (this.major1 != null) {
            grpSj1 = subService.getListSubjectByMajorId(major1.getId());
        }
    }

    public void searchSubject2() {
        grpSj2 = new ArrayList<>();
        if (major2 != null) {
            grpSj2 = subService.getListSubjectByMajorId(major2.getId());
        }
    }

    public void choseSubject1() {
        this.totalMark1 = StringUtillStudy.getTotalMark(student, sub1, major1);
    }

    public void choseSubject2() {
        this.totalMark2 = StringUtillStudy.getTotalMark(student, sub2, major2);
    }

    public String submit() {
        listDetail = new ArrayList<>();
        if (student != null && this.major1 != null && this.sub1 != null && this.schChose != null) {
            log.debug("Make new registration 1.");
            RegistrationDetail detail1 = getRegistrationDetail(student, schChose, major1, sub1, totalMark1);
            listDetail.add(detail1);
        }

        if (student != null && major2 != null && sub2 != null && schChose != null) {
            log.debug("Make new registration 2.");
            RegistrationDetail detail2 = getRegistrationDetail(student, schChose, major2, sub2, totalMark2);
            listDetail.add(detail2);
        }

        if (!CollectionUtils.isEmpty(listDetail) && listDetail.size() == 2) {
            log.debug("send list detail to Context");
            ObjectUtils.putObjectContext(CommonContanst.LIST_DETAIL, null);
            ObjectUtils.putObjectContext(CommonContanst.LIST_DETAIL, listDetail);
            if (!StringUtils.isEmpty(student.getEmail().trim())) {
                log.debug("Send email OTP to Student");
                String otp = StringUtillStudy.randomAlphaNumeric();
                ObjectUtils.putObjectContext(CommonContanst.OTP, otp);
                SendEmail.startSendEmail(student, otp);
            }
            return CommonContanst.SUCCESS;
        }
        return CommonContanst.FAIL;
    }

    public String turnBack() {
        return CommonContanst.SUCCESS;
    }

    private RegistrationDetail getRegistrationDetail(Student student, School sch, Majors major, GroupSubjects sub,
            String totalMark) {
        RegistrationDetail detail = new RegistrationDetail();
        detail.setStudent(student);
        detail.setMajor(major);
        detail.setGroupSubjects(sub);
        detail.setSchool(sch);
        detail.setTotalMark(totalMark);
        return detail;
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
     * @return the schChose
     */
    public School getSchChose() {
        return schChose;
    }

    /**
     * @param schChose
     *            the schChose to set
     */
    public void setSchChose(School schChose) {
        this.schChose = schChose;
    }

    /**
     * @return the majors1
     */
    public List<Majors> getMajors1() {
        return majors1;
    }

    /**
     * @param majors1
     *            the majors1 to set
     */
    public void setMajors1(List<Majors> majors1) {
        this.majors1 = majors1;
    }

    /**
     * @return the grpSj1
     */
    public List<GroupSubjects> getGrpSj1() {
        return grpSj1;
    }

    /**
     * @param grpSj1
     *            the grpSj1 to set
     */
    public void setGrpSj1(List<GroupSubjects> grpSj1) {
        this.grpSj1 = grpSj1;
    }

    /**
     * @return the major1
     */
    public Majors getMajor1() {
        return major1;
    }

    /**
     * @param major1
     *            the major1 to set
     */
    public void setMajor1(Majors major1) {
        this.major1 = major1;
    }

    /**
     * @return the sub1
     */
    public GroupSubjects getSub1() {
        return sub1;
    }

    /**
     * @param sub1
     *            the sub1 to set
     */
    public void setSub1(GroupSubjects sub1) {
        this.sub1 = sub1;
    }

    /**
     * @return the totalMark1
     */
    public String getTotalMark1() {
        return totalMark1;
    }

    /**
     * @param totalMark1
     *            the totalMark1 to set
     */
    public void setTotalMark1(String totalMark1) {
        this.totalMark1 = totalMark1;
    }

    /**
     * @return the majors2
     */
    public List<Majors> getMajors2() {
        return majors2;
    }

    /**
     * @param majors2
     *            the majors2 to set
     */
    public void setMajors2(List<Majors> majors2) {
        this.majors2 = majors2;
    }

    /**
     * @return the grpSj2
     */
    public List<GroupSubjects> getGrpSj2() {
        return grpSj2;
    }

    /**
     * @param grpSj2
     *            the grpSj2 to set
     */
    public void setGrpSj2(List<GroupSubjects> grpSj2) {
        this.grpSj2 = grpSj2;
    }

    /**
     * @return the major2
     */
    public Majors getMajor2() {
        return major2;
    }

    /**
     * @param major2
     *            the major2 to set
     */
    public void setMajor2(Majors major2) {
        this.major2 = major2;
    }

    /**
     * @return the sub2
     */
    public GroupSubjects getSub2() {
        return sub2;
    }

    /**
     * @param sub2
     *            the sub2 to set
     */
    public void setSub2(GroupSubjects sub2) {
        this.sub2 = sub2;
    }

    /**
     * @return the totalMark2
     */
    public String getTotalMark2() {
        return totalMark2;
    }

    /**
     * @param totalMark2
     *            the totalMark2 to set
     */
    public void setTotalMark2(String totalMark2) {
        this.totalMark2 = totalMark2;
    }

}
