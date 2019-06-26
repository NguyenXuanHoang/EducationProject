package vn.iomedia.ipay.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import com.microsoft.sqlserver.jdbc.StringUtils;

import vn.iomedia.ipay.contanst.CommonContanst;
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

@ManagedBean(name = "major4Chose", eager = true)
@ViewScoped
public class Major4Chose implements Serializable {

    private static final long serialVersionUID = -4057556628266352443L;
    private Logger log = Logger.getLogger(Major4Chose.class);

    private Student student;
    private School school;
    private List<School> schoolsSelect;
    private List<RegistrationDetail> listDetail;

    private List<Majors> majors1;
    private List<GroupSubjects> grpSj1;
    private School schChose1;
    private Majors major1;
    private GroupSubjects sub1;
    private String totalMark1;

    private List<Majors> majors2;
    private List<GroupSubjects> grpSj2;
    private School schChose2;
    private Majors major2;
    private GroupSubjects sub2;
    private String totalMark2;

    private List<Majors> majors3;
    private List<GroupSubjects> grpSj3;
    private School schChose3;
    private Majors major3;
    private GroupSubjects sub3;
    private String totalMark3;

    private List<Majors> majors4;
    private List<GroupSubjects> grpSj4;
    private School schChose4;
    private Majors major4;
    private GroupSubjects sub4;
    private String totalMark4;

    private MajorService majorService = new MajorServiceImpl();
    private GroupSubjectService subService = new GroupSubjectsServiceImpl();

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        try {
            log.debug("get Student,listSchool,schoolSelect from Context in Major4chose page");
            this.student = (Student) ObjectUtils.getObjectByString(CommonContanst.STUDENT);
            this.school = (School) ObjectUtils.getObjectByString(CommonContanst.SCHOOL);
            this.schoolsSelect = (List<School>) ObjectUtils.getObjectByString(CommonContanst.LIST_SCHOOL);
            if (schChose1 == null) {
                log.debug("Schoole Choose 1 null,set data default for layout.");
                if (!CollectionUtils.isEmpty(schoolsSelect)) {
                    this.majors1 = majorService.getListMajorBySchoolId(schoolsSelect.get(0).getId());
                    if (!CollectionUtils.isEmpty(majors1)) {
                        this.grpSj1 = subService.getListSubjectByMajorId(majors1.get(0).getId());
                    }
                }
            }

            if (schChose2 == null) {
                log.debug("Schoole Choose 2 null,set data default for layout.");
                if (!CollectionUtils.isEmpty(schoolsSelect)) {
                    this.majors2 = majorService.getListMajorBySchoolId(schoolsSelect.get(0).getId());
                    if (!CollectionUtils.isEmpty(majors2)) {
                        this.grpSj2 = subService.getListSubjectByMajorId(majors2.get(0).getId());
                    }
                }
            }

            if (schChose3 == null) {
                log.debug("Schoole Choose 3 null,set data default for layout.");
                if (!CollectionUtils.isEmpty(schoolsSelect)) {
                    this.majors3 = majorService.getListMajorBySchoolId(schoolsSelect.get(0).getId());
                    if (!CollectionUtils.isEmpty(majors3)) {
                        this.grpSj3 = subService.getListSubjectByMajorId(majors3.get(0).getId());
                    }
                }
            }

            if (schChose4 == null) {
                log.debug("Schoole Choose 4 null,set data default for layout.");
                if (!CollectionUtils.isEmpty(schoolsSelect)) {
                    this.majors4 = majorService.getListMajorBySchoolId(schoolsSelect.get(0).getId());
                    if (!CollectionUtils.isEmpty(majors4)) {
                        this.grpSj4 = subService.getListSubjectByMajorId(majors4.get(0).getId());
                    }
                }
            }
        } catch (Exception exp) {
            log.error(exp.getMessage());
        }
    }

    public void searchMajor1() {
        if (schChose1 != null) {
            this.majors1 = majorService.getListMajorBySchoolId(schChose1.getId());
        }
    }

    public void searchMajor2() {
        if (schChose2 != null) {
            majors2 = majorService.getListMajorBySchoolId(schChose2.getId());
        }
    }

    public void searchMajor3() {
        if (schChose3 != null) {
            this.majors3 = majorService.getListMajorBySchoolId(schChose3.getId());
        }
    }

    public void searchMajor4() {
        if (schChose4 != null) {
            majors4 = majorService.getListMajorBySchoolId(schChose4.getId());
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

    public void searchSubject3() {
        grpSj3 = new ArrayList<>();
        if (this.major3 != null) {
            grpSj3 = subService.getListSubjectByMajorId(major3.getId());
        }
    }

    public void searchSubject4() {
        grpSj4 = new ArrayList<>();
        if (major4 != null) {
            grpSj4 = subService.getListSubjectByMajorId(major4.getId());
        }
    }

    public void choseSubject1() {
        this.totalMark1 = StringUtillStudy.getTotalMark(student, sub1, major1);
    }

    public void choseSubject2() {
        this.totalMark2 = StringUtillStudy.getTotalMark(student, sub2, major2);
    }

    public void choseSubject3() {
        this.totalMark3 = StringUtillStudy.getTotalMark(student, sub3, major3);
    }

    public void choseSubject4() {
        this.totalMark4 = StringUtillStudy.getTotalMark(student, sub4, major4);
    }

    public String submit() {
        listDetail = new ArrayList<>();
        if (student != null && this.major1 != null && this.sub1 != null && this.schChose1 != null) {
            RegistrationDetail detail1 = getRegistrationDetail(student, schChose1, major1, sub1, totalMark1);
            detail1.setOrderAspiration(1);
            listDetail.add(detail1);
        }

        if (student != null && major2 != null && sub2 != null && schChose2 != null) {
            RegistrationDetail detail2 = getRegistrationDetail(student, schChose2, major2, sub2, totalMark2);
            detail2.setOrderAspiration(2);
            listDetail.add(detail2);
        }

        if (student != null && this.major3 != null && this.sub3 != null && this.schChose3 != null) {
            RegistrationDetail detail3 = getRegistrationDetail(student, schChose3, major3, sub3, totalMark3);
            detail3.setOrderAspiration(3);
            listDetail.add(detail3);
        }

        if (student != null && major4 != null && sub4 != null && schChose4 != null) {
            RegistrationDetail detail4 = getRegistrationDetail(student, schChose4, major4, sub4, totalMark4);
            detail4.setOrderAspiration(4);
            listDetail.add(detail4);
        }

        if (!CollectionUtils.isEmpty(listDetail) && listDetail.size() == 4) {
            log.debug("check logic 1 school have only 2 major");
            if (!checklogicOneSchoolTwoMajor(listDetail)) {
                return CommonContanst.FAIL;
            }
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

    private boolean checklogicOneSchoolTwoMajor(List<RegistrationDetail> listDetail) {
        for (int i = 0; i < listDetail.size(); i++) {
            int total = 0;
            for (int j = i + 1; j < listDetail.size(); j++) {
                if (listDetail.get(i).getSchool().getName().equals(listDetail.get(j).getSchool().getName())) {
                    total++;
                    if (total >= 2) {
                        return false;
                    }
                }
            }
        }
        return true;
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
     * @return the schChose1
     */
    public School getSchChose1() {
        return schChose1;
    }

    /**
     * @param schChose1
     *            the schChose1 to set
     */
    public void setSchChose1(School schChose1) {
        this.schChose1 = schChose1;
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
     * @return the schChose2
     */
    public School getSchChose2() {
        return schChose2;
    }

    /**
     * @param schChose2
     *            the schChose2 to set
     */
    public void setSchChose2(School schChose2) {
        this.schChose2 = schChose2;
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
     * @return the majorService
     */
    public MajorService getMajorService() {
        return majorService;
    }

    /**
     * @param majorService
     *            the majorService to set
     */
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    /**
     * @return the subService
     */
    public GroupSubjectService getSubService() {
        return subService;
    }

    /**
     * @param subService
     *            the subService to set
     */
    public void setSubService(GroupSubjectService subService) {
        this.subService = subService;
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

    /**
     * @return the majors3
     */
    public List<Majors> getMajors3() {
        return majors3;
    }

    /**
     * @param majors3
     *            the majors3 to set
     */
    public void setMajors3(List<Majors> majors3) {
        this.majors3 = majors3;
    }

    /**
     * @return the grpSj3
     */
    public List<GroupSubjects> getGrpSj3() {
        return grpSj3;
    }

    /**
     * @param grpSj3
     *            the grpSj3 to set
     */
    public void setGrpSj3(List<GroupSubjects> grpSj3) {
        this.grpSj3 = grpSj3;
    }

    /**
     * @return the schChose3
     */
    public School getSchChose3() {
        return schChose3;
    }

    /**
     * @param schChose3
     *            the schChose3 to set
     */
    public void setSchChose3(School schChose3) {
        this.schChose3 = schChose3;
    }

    /**
     * @return the major3
     */
    public Majors getMajor3() {
        return major3;
    }

    /**
     * @param major3
     *            the major3 to set
     */
    public void setMajor3(Majors major3) {
        this.major3 = major3;
    }

    /**
     * @return the sub3
     */
    public GroupSubjects getSub3() {
        return sub3;
    }

    /**
     * @param sub3
     *            the sub3 to set
     */
    public void setSub3(GroupSubjects sub3) {
        this.sub3 = sub3;
    }

    /**
     * @return the totalMark3
     */
    public String getTotalMark3() {
        return totalMark3;
    }

    /**
     * @param totalMark3
     *            the totalMark3 to set
     */
    public void setTotalMark3(String totalMark3) {
        this.totalMark3 = totalMark3;
    }

    /**
     * @return the majors4
     */
    public List<Majors> getMajors4() {
        return majors4;
    }

    /**
     * @param majors4
     *            the majors4 to set
     */
    public void setMajors4(List<Majors> majors4) {
        this.majors4 = majors4;
    }

    /**
     * @return the grpSj4
     */
    public List<GroupSubjects> getGrpSj4() {
        return grpSj4;
    }

    /**
     * @param grpSj4
     *            the grpSj4 to set
     */
    public void setGrpSj4(List<GroupSubjects> grpSj4) {
        this.grpSj4 = grpSj4;
    }

    /**
     * @return the schChose4
     */
    public School getSchChose4() {
        return schChose4;
    }

    /**
     * @param schChose4
     *            the schChose4 to set
     */
    public void setSchChose4(School schChose4) {
        this.schChose4 = schChose4;
    }

    /**
     * @return the major4
     */
    public Majors getMajor4() {
        return major4;
    }

    /**
     * @param major4
     *            the major4 to set
     */
    public void setMajor4(Majors major4) {
        this.major4 = major4;
    }

    /**
     * @return the sub4
     */
    public GroupSubjects getSub4() {
        return sub4;
    }

    /**
     * @param sub4
     *            the sub4 to set
     */
    public void setSub4(GroupSubjects sub4) {
        this.sub4 = sub4;
    }

    /**
     * @return the totalMark4
     */
    public String getTotalMark4() {
        return totalMark4;
    }

    /**
     * @param totalMark4
     *            the totalMark4 to set
     */
    public void setTotalMark4(String totalMark4) {
        this.totalMark4 = totalMark4;
    }

    /**
     * @return the school
     */
    public School getSchool() {
        return school;
    }

    /**
     * @param school
     *            the school to set
     */
    public void setSchool(School school) {
        this.school = school;
    }
}
