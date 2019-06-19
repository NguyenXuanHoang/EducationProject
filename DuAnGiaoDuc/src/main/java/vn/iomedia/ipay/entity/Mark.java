package vn.iomedia.ipay.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mark")
public class Mark implements Serializable {

    private static final long serialVersionUID = -1845279184457170613L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "math")
    private double math;

    @Column(name = "literature")
    private double literature;

    @Column(name = "physical")
    private double physical;

    @Column(name = "chemistry")
    private double chemistry;

    @Column(name = "english")
    private double english;

    @Column(name = "orther_language")
    private double ortherLanguage;

    @OneToOne(mappedBy = "mark")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getLiterature() {
        return literature;
    }

    public void setLiterature(double literature) {
        this.literature = literature;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    /**
     * @return the ortherLanguage
     */
    public double getOrtherLanguage() {
        return ortherLanguage;
    }

    /**
     * @param ortherLanguage
     *            the ortherLanguage to set
     */
    public void setOrtherLanguage(double ortherLanguage) {
        this.ortherLanguage = ortherLanguage;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
