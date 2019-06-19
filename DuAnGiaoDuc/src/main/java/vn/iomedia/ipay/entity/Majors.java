package vn.iomedia.ipay.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "major")
public class Majors implements Serializable {

    private static final long serialVersionUID = -7877475624643446259L;

    public String toName() {
        StringBuilder sb = new StringBuilder();
        sb.append(codeMajor);
        sb.append(" - ");
        sb.append(nameMajor);
        return sb.toString();

    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code_major")
    private String codeMajor;

    @Column(name = "name_major")
    private String nameMajor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "school_fk", referencedColumnName = "id")
    private School school;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "major")
    private List<MajorGroupSubject> majorGroupSubjects;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "major")
    private List<RegistrationDetail> registrationDetails;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeMajor() {
        return codeMajor;
    }

    public void setCodeMajor(String codeMajor) {
        this.codeMajor = codeMajor;
    }

    public String getNameMajor() {
        return nameMajor;
    }

    public void setNameMajor(String nameMajor) {
        this.nameMajor = nameMajor;
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

    @Override
    public boolean equals(Object other) {
        return (other != null && getClass() == other.getClass()) ? id == (((Majors) other).id) : (other == this);
    }

    @Override
    public int hashCode() {
        return (id > 0) ? (getClass().hashCode() + String.valueOf(id).hashCode()) : super.hashCode();
    }
}
