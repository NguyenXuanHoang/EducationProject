package vn.iomedia.ipay.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "group_subject")
public class GroupSubjects implements Serializable {

    private static final long serialVersionUID = -3238426053321068846L;

    public String toName() {
        StringBuilder sb = new StringBuilder();
        sb.append(codeGroupSubject);
        sb.append(" - ");
        sb.append(codeSubject1);
        sb.append(" - ");
        sb.append(codeSubject2);
        sb.append(" - ");
        sb.append(codeSubject3);
        return sb.toString();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "code_group_subject")
    private String codeGroupSubject;

    @Column(name = "code_subject1")
    private String codeSubject1;

    @Column(name = "code_subject2")
    private String codeSubject2;

    @Column(name = "code_subject3")
    private String codeSubject3;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groupsSubject")
    private List<MajorGroupSubject> majorGroupSubjects;

    @OneToMany(mappedBy = "groupSubjects")
    private List<RegistrationDetail> registrationDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeGroupSubject() {
        return codeGroupSubject;
    }

    public void setCodeGroupSubject(String codeGroupSubject) {
        this.codeGroupSubject = codeGroupSubject;
    }

    public String getCodeSubject1() {
        return codeSubject1;
    }

    public void setCodeSubject1(String codeSubject1) {
        this.codeSubject1 = codeSubject1;
    }

    public String getCodeSubject2() {
        return codeSubject2;
    }

    public void setCodeSubject2(String codeSubject2) {
        this.codeSubject2 = codeSubject2;
    }

    public String getCodeSubject3() {
        return codeSubject3;
    }

    public void setCodeSubject3(String codeSubject3) {
        this.codeSubject3 = codeSubject3;
    }

    /**
     * @return the majorGroupSubjects
     */
    public List<MajorGroupSubject> getMajorGroupSubjects() {
        return majorGroupSubjects;
    }

    /**
     * @param majorGroupSubjects
     *            the majorGroupSubjects to set
     */
    public void setMajorGroupSubjects(List<MajorGroupSubject> majorGroupSubjects) {
        this.majorGroupSubjects = majorGroupSubjects;
    }

    /**
     * @return the registrationDetails
     */
    public List<RegistrationDetail> getRegistrationDetails() {
        return registrationDetails;
    }

    /**
     * @param registrationDetails
     *            the registrationDetails to set
     */
    public void setRegistrationDetails(List<RegistrationDetail> registrationDetails) {
        this.registrationDetails = registrationDetails;
    }

    @Override
    public boolean equals(Object other) {
        return (other != null && getClass() == other.getClass()) ? id == (((GroupSubjects) other).id) : (other == this);
    }

    @Override
    public int hashCode() {
        return (id > 0) ? (getClass().hashCode() + String.valueOf(id).hashCode()) : super.hashCode();
    }
}
