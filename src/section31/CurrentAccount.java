package section31;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="currentAccount")
public class CurrentAccount {
    private Integer id;
    private String number;
    private User user;

    // getter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idCurrentAccount")
    public Integer getId() {
        return this.id;
    }
    
    @Column(name="numberAccount")
    public String getNumber() {
        return this.number;
    }
    
    @ManyToOne
    @Column(name="numberAccount")
    @JoinColumn(name="idUser")
    public User getUser() {
        return this.user;
    }

    // setter
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
}
