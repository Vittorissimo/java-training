package section31;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
    private Integer id;
    private String name;

    // getter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idCourse")
    public Integer getId() {
        return this.id;
    }
    
    @Column(name="nameCourse")
    public String getName() {
        return this.name;
    }

    // setter
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
