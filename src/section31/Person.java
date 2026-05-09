package section31;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person{
    private Long id;
    private String name;
    private String surname;
    private int age;

    // getter
    @Id
    @Column(name="id_person")
    public Long getId() {
        return this.id;
    }
    
    @Column(name="name", nullable=false, length=100)
    public String getName() {
        return this.name;
    }
    
    @Column(name="surname")
    public String getSurname() {
        return this.surname;
    }
    
    @Column(name="age")
    public int getAge() {
        return this.age;
    }

    // setter
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}