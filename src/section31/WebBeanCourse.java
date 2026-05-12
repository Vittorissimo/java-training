package section31;

import java.util.Date;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class WebBeanCourse {
    @PersistenceContext(unitName="webCoursePersistence")
    EntityManager manager;

    public WebBeanCourse(){

    }

    @Interceptors({WebInterceptorCourse.class})
    public String greeting() {
        saveInvoice();
        printInvoice();

        return "Hi, I'm an EJB!";
    }

    public void saveInvoice() {
        Invoice i = new Invoice();
        i.setDateInvoice(new Date());
        i.setNumberInvoice("1234");
        
        Client c = new Client();
        c.setSurname("Rossi");
        c.setName("Mario");

        i.setClient(c);

        manager.persist(i);
    }

    public void printInvoice() {
        Invoice i = manager.find(Invoice.class, 1);

        i.getClient().getName();
    }
}
