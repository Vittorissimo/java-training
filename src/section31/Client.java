package section31;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Client {
    private String name;
    private String surname;

    // getter
    @Column(name="name", table="client")
    public String getName() {
        return this.name;
    }
    
    @Column(name="surname", table="client")
    public String getSurname() {
        return this.surname;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
