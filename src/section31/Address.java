package section31;

import javax.persistence.Column;
import javax.persistence.Id;

public class Address {
    private Long id;
    private String via;
    private String city;

    // getter
    @Id
    @Column(name="id_address")
    public Long getId() {
        return this.id;
    }
    
    public String getVia() {
        return this.via;
    }
    
    public String getCity() {
        return this.city;
    }

    // setter
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setVia(String via) {
        this.via = via;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
}
