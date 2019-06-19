package vn.iomedia.ipay.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "major_groupSubject")
public class MajorGroupSubject implements Serializable{

    private static final long serialVersionUID = -5853311384272939113L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "major_fk", referencedColumnName = "id")
    private Majors major;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "group_subject_fk", referencedColumnName = "id")
    private GroupSubjects groupsSubject;

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

    /**
     * @return the groupsSubject
     */
    public GroupSubjects getGroupsSubject() {
        return groupsSubject;
    }

    /**
     * @param groupsSubject
     *            the groupsSubject to set
     */
    public void setGroupsSubject(GroupSubjects groupsSubject) {
        this.groupsSubject = groupsSubject;
    }
}
