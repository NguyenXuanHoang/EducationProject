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
@Table (name = "priority_area")
public class PriorityArea implements Serializable{

    private static final long serialVersionUID = -2355862343960344035L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
	@Column (name = "code_area")
	private String codeArea;
	
	@Column (name = "priority_mark")
	private double priorityMark;
	
	@OneToOne(mappedBy = "priorityArea")
	private Student student;

	public String getCodeArea() {
		return codeArea;
	}

	public void setCodeArea(String codeArea) {
		this.codeArea = codeArea;
	}

	public double getPriorityMark() {
		return priorityMark;
	}

	public void setPriorityMark(double priorityMark) {
		this.priorityMark = priorityMark;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public PriorityArea() {
		super();
	}

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
	
	
	
}
