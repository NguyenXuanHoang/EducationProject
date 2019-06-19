package vn.iomedia.ipay.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table (name = "priority_object")
@Entity
public class PriorityObject implements Serializable{

    private static final long serialVersionUID = 29029179973582595L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

	@Column (name = "code_object")
	private String codeObject;
	
	@Column (name = "priority_mark")
	private double priorityMark;
	
	@OneToOne(mappedBy = "priorityObject")
	private Student student;

	public String getCodeObject() {
		return codeObject;
	}

	public void setCodeObject(String codeObject) {
		this.codeObject = codeObject;
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

	public PriorityObject() {
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
