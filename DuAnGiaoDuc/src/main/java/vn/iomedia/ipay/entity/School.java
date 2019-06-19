package vn.iomedia.ipay.entity;

import java.io.Serializable;
import java.util.List;

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
@Table(name = "school")
public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "code_school")
    private String codeSchool;

    @Column(name = "name_school")
    private String name;

    @Column(name = "address_school")
    private String address;

    @ManyToOne
    @JoinColumn(name = "group_school_fk", referencedColumnName = "id")
    private GroupSchool groupSchool;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "school")
    private List<Majors> major;

    @OneToMany(mappedBy = "school")
    private List<RegistrationDetail> registrationDetails;

    public String getCodeSchool() {
        return codeSchool;
    }

    public void setCodeSchool(String codeSchool) {
        this.codeSchool = codeSchool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the major
     */
    public List<Majors> getMajor() {
        return major;
    }

    /**
     * @param major
     *            the major to set
     */
    public void setMajor(List<Majors> major) {
        this.major = major;
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

    /**
     * @return the groupSchool
     */
    public GroupSchool getGroupSchool() {
        return groupSchool;
    }

    /**
     * @param groupSchool
     *            the groupSchool to set
     */
    public void setGroupSchool(GroupSchool groupSchool) {
        this.groupSchool = groupSchool;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public String toName() {
        StringBuilder sb = new StringBuilder();
        sb.append(codeSchool);
        sb.append(" - ");
        sb.append(name);
        return sb.toString();
    }

    @Override
    public boolean equals(Object other) {
        return (other != null && getClass() == other.getClass()) ? id == (((School) other).id) : (other == this);
    }

    @Override
    public int hashCode() {
        return (id > 0) ? (getClass().hashCode() + String.valueOf(id).hashCode()) : super.hashCode();
    }

}
