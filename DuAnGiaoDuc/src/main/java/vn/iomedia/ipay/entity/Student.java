package vn.iomedia.ipay.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.microsoft.sqlserver.jdbc.StringUtils;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = -2308466966505689177L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "id_number", unique = true)
    private String idNumber;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "day_of_birth")
    private String dob;

    @Column(name = "id_card", unique = true)
    private String idCard;

    @Column(name = "addr")
    private String address;

    @Column(name = "pass")
    private String password;
    
    @Column(name = "number_regis")
    private Integer numberRegis;

    @OneToMany(mappedBy = "student")
    private List<RegistrationDetail> registrationDetails;

    @OneToOne
    @JoinColumn(name = "priority_area_fk")
    private PriorityArea priorityArea;

    @OneToOne
    @JoinColumn(name = "priority_object_fk")
    private PriorityObject priorityObject;

    @OneToOne
    @JoinColumn(name = "mark_fk")
    private Mark mark;

    /**
     * @return the priorityArea
     */
    public PriorityArea getPriorityArea() {
        return priorityArea;
    }

    /**
     * @param priorityArea
     *            the priorityArea to set
     */
    public void setPriorityArea(PriorityArea priorityArea) {
        this.priorityArea = priorityArea;
    }

    /**
     * @return the priorityObject
     */
    public PriorityObject getPriorityObject() {
        return priorityObject;
    }

    /**
     * @param priorityObject
     *            the priorityObject to set
     */
    public void setPriorityObject(PriorityObject priorityObject) {
        this.priorityObject = priorityObject;
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

    /**
     * @return the idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber
     *            the idNumber to set
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob
     *            the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     *            the idCard to set
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public List<RegistrationDetail> getRegistrationDetails() {
        return registrationDetails;
    }

    public void setRegistrationDetails(List<RegistrationDetail> registrationDetails) {
        this.registrationDetails = registrationDetails;
    }
    
    /**
     * @return the numberRegis
     */
    public Integer getNumberRegis() {
        return numberRegis;
    }

    /**
     * @param numberRegis the numberRegis to set
     */
    public void setNumberRegis(Integer numberRegis) {
        this.numberRegis = numberRegis;
    }

    public String getStudentName() {
        if (!StringUtils.isEmpty(this.firstName) && !StringUtils.isEmpty(this.lastName)) {
            StringBuilder sb = new StringBuilder();
            sb.append(firstName.toUpperCase().trim());
            sb.append(" ");
            sb.append(lastName.toUpperCase().trim());
            return sb.toString();
        }
        return null;
    };
}
