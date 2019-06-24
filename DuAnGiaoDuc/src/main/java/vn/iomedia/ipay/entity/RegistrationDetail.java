package vn.iomedia.ipay.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "registration_detail")
@Entity
public class RegistrationDetail implements Serializable {

    private static final long serialVersionUID = -4529070972928695191L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_number_fk", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "school_fk", referencedColumnName = "id")
    private School school;

    @ManyToOne
    @JoinColumn(name = "major_fk", referencedColumnName = "id")
    private Majors major;

    @ManyToOne
    @JoinColumn(name = "group_subject_fk", referencedColumnName = "id")
    private GroupSubjects groupSubjects;

    @OneToOne
    @JoinColumn(name = "online_payment_fk", referencedColumnName = "id")
    private OnlinePaymentDetail onlinePaymentDetail;

    @Column(name = "total_mark")
    private String totalMark;

    @Column(name = "order_aspiration")
    private int orderAspiration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    /**
     * @return the major
     */
    public Majors getMajor() {
        return major;
    }

    /**
     * @param major
     *            the major to set
     */
    public void setMajor(Majors major) {
        this.major = major;
    }

    public GroupSubjects getGroupSubjects() {
        return groupSubjects;
    }

    public void setGroupSubjects(GroupSubjects groupSubjects) {
        this.groupSubjects = groupSubjects;
    }

    /**
     * @return the onlinePaymentDetail
     */
    public OnlinePaymentDetail getOnlinePaymentDetail() {
        return onlinePaymentDetail;
    }

    /**
     * @param onlinePaymentDetail
     *            the onlinePaymentDetail to set
     */
    public void setOnlinePaymentDetail(OnlinePaymentDetail onlinePaymentDetail) {
        this.onlinePaymentDetail = onlinePaymentDetail;
    }

    /**
     * @return the totalMark
     */
    public String getTotalMark() {
        return totalMark;
    }

    /**
     * @param totalMark
     *            the totalMark to set
     */
    public void setTotalMark(String totalMark) {
        this.totalMark = totalMark;
    }

    /**
     * @return the orderAspiration
     */
    public int getOrderAspiration() {
        return orderAspiration;
    }

    /**
     * @param orderAspiration
     *            the orderAspiration to set
     */
    public void setOrderAspiration(int orderAspiration) {
        this.orderAspiration = orderAspiration;
    }
}
