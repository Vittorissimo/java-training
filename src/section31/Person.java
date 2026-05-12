package section31;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person{
    private Long id;
    private String name;
    private String surname;
    private int age;

    private Account account;

    // private List<Address> address;

    // getter
    @Id
    @Column(name="id_person")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idAccount")
    public Account getAccount() {
        return this.account;
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
    
    public void setAccount(Account account) {
        this.account = account;
    }
}