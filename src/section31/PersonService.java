package section31;

import javax.ejb.Local;

public interface PersonService {
    public void savePerson(PersonServlet p);
    public void update(Person p);
    public void deletePerson(Person p);
    public Person getPersonById(Long id);
    public void createAccount();
    public void createAnAccountAssociatedWithAUser();
    public void assignStudentToTheCourse();
}
