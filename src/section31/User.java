package section31;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
@NamedQuery(name="userList", query="SELECT u FROM u")
public class User {
    private Integer id;
    private String name;
    private String surname;

    private List<CurrentAccount> cuAc;
    
    // getter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idUser")
    public Integer getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getSurname() {
        return this.surname;
    }

    @OneToMany(mappedBy="userAccount", cascade=CascadeType.ALL)
    public List<CurrentAccount> getCurrentAccount() {
        return this.cuAc;
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

    public void setCurrentAccount(List<CurrentAccount> cuAc) {
        this.cuAc = cuAc;
    }
}
