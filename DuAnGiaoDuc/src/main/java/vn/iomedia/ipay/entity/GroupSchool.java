package vn.iomedia.ipay.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "group_school")
public class GroupSchool implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column(name = "group_school")
    private String groupSchool;
	
	@Column(name = "number_choose")
    private int numberChose;
	
	@OneToMany(mappedBy = "groupSchool")
    private List<School> school;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupSchool() {
		return groupSchool;
	}

	public void setGroupSchool(String groupSchool) {
		this.groupSchool = groupSchool;
	}

	public int getNumberChose() {
		return numberChose;
	}

	public void setNumberChose(int numberChose) {
		this.numberChose = numberChose;
	}

    /**
     * @return the school
     */
    public List<School> getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(List<School> school) {
        this.school = school;
    }

}
