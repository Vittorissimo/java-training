package section31;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    public void createAnAccountAssociatedWithAUser() {
        User u = manager.find(User.class, 3);

        CurrentAccount c = new CurrentAccount();
        c.setNumber("2222222");
        c.setUser(u);

        manager.persist(c);
    }

    public void createAccount() {
        User u2 = new User();
        u2.setSurname("Verdi");
        u2.setName("Luigi");

        CurrentAccount c3 = new CurrentAccount();
        c3.setNumber("1919191");
        c3.setUser(u2);

        manager.persist(c3);


        User u = new User();
        u.setSurname("Rossi");
        u.setName("Mario");
        u.setCurrentAccount(new ArrayList<CurrentAccount>());

        CurrentAccount c1 = new CurrentAccount();
        c1.setNumber("1234");
        c1.setUser(u);
        u.getCurrentAccount().add(c1);
        
        CurrentAccount c2 = new CurrentAccount();
        c2.setNumber("5678");
        c2.setUser(u);
        u.getCurrentAccount().add(c2);

        manager.persist(u);
    }

    public void assignStudentToTheCourse() {
        Course c = manager.find(Course.class, 2);

        Student s = new Student();
        s.setSurname("Bianchi");
        s.setName("Valeria");

        s.setCourseList(new ArrayList<Course>());
        s.getCourseList().add(c);

        manager.persist(s);
    }

    public long userListCount() {
        Query q = manager.createQuery("SELECT (u.count(u.id)) FROM User u");

        return (long)q.getSingleResult();
    }

    public void userList(int p, int maxResults) {
        Query q = manager.createNamedQuery("userList");

        List<User> users = q.getResultList();

        for (User u : users) {
            System.out.println(u.getSurname() + " " + u.getName());
        }

        Query q2 = manager.createQuery("SELECT u FROM User WHERE u.surname = :c");

        q2.setFirstResult(p);
        q2.setMaxResults(maxResults);

        q2.setParameter("c", "Verdi");
        List<User> users2 = q2.getResultList();
    }
}
