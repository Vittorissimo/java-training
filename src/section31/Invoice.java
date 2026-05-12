package section31;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="invoice")
@SecondaryTable(name="client", pkJoinColumns={@PrimaryKeyJoinColumn(name="idClient")})
public class Invoice {
    private Integer id;
    private String numberInvoice;
    private Date dateInvoice;

    private Client client;

    // getter
    @Id
    @Column(name="idInvoice")
    public Integer getId() {
        return this.id;
    }
    
    @Column(name="number")
    public String getNumberInvoice() {
        return this.numberInvoice;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name="dateInvoice")
    public Date getDateInvoice() {
        return this.dateInvoice;
    }
    
    @Embedded
    public Client getClient() {
        return this.client;
    }

    // setter
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setNumberInvoice(String numberInvoice) {
        this.numberInvoice = numberInvoice;
    }
    
    public void setDateInvoice(Date dateInvoice) {
        this.dateInvoice = dateInvoice;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
}
