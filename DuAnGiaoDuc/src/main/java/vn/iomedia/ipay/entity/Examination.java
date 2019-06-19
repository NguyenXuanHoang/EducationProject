package vn.iomedia.ipay.entity;



import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "examination")
public class Examination implements Serializable{

    private static final long serialVersionUID = -6265340306945150484L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column (name = "admissions")
	private int Admissions;
	
	@Column (name = "time_admissions")
	private int timeAdmissions;
	
	@Column (name = "begin_admissions")
	private Date beginAdmissions;
	
	@Column (name = "end_admissions")
	private Date endAdmissions;
	
	@Column (name = "group_school_number")
	private int groupSchoolNumber;
	
	@Column (name = "single_school_number")
	private int singleSchoolNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAdmissions() {
		return Admissions;
	}

	public void setAdmissions(int admissions) {
		Admissions = admissions;
	}

	public int getTimeAdmissions() {
		return timeAdmissions;
	}

	public void setTimeAdmissions(int timeAdmissions) {
		this.timeAdmissions = timeAdmissions;
	}

	public Date getBeginAdmissions() {
		return beginAdmissions;
	}

	public void setBeginAdmissions(Date beginAdmissions) {
		this.beginAdmissions = beginAdmissions;
	}

	public Date getEndAdmissions() {
		return endAdmissions;
	}

	public void setEndAdmissions(Date endAdmissions) {
		this.endAdmissions = endAdmissions;
	}

	public int getGroupSchoolNumber() {
		return groupSchoolNumber;
	}

	public void setGroupSchoolNumber(int groupSchoolNumber) {
		this.groupSchoolNumber = groupSchoolNumber;
	}

	public int getSingleSchoolNumber() {
		return singleSchoolNumber;
	}

	public void setSingleSchoolNumber(int singleSchoolNumber) {
		this.singleSchoolNumber = singleSchoolNumber;
	}
}
