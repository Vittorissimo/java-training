package section31;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonServiceBean implements PersonServiceBeanRemote, PersonServiceBeanLocal {
    @PersistenceContext(unitName="java-trainingPersistence")
    EntityManager manager;

    public PersonServiceBean() {

    }

    public void savePerson(Person p) {
        manager.persist(p);
    }
    
    public void update(Person p) {
        manager.merge(p);
    }
    
    public void deletePerson(Person p) {
        manager.remove(p);
    }

    public Person getPersonById(Long id){
        return manager.find(Person.class, id);
    }
}