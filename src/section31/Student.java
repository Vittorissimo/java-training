package section31;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    private Integer id;
    private String name;
    private String surname;

    private List<Course> lc;
    
    // getter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idStudent")
    public Integer getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getSurname() {
        return this.surname;
    }
    
    @ManyToMany
    @JoinTable(
        name="courseStudent",
        joinColumns={@JoinColumn(name="idStudent", referencedColumnName="idStudent")},
        inverseJoinColumns={@JoinColumn(name="idCourse", referencedColumnName="idCourse")}
    )
    public List<Course> getCourseList() {
        return this.lc;
    }

    // setter
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setCourseList(List<Course> lc) {
        this.lc = lc;
    }
}
