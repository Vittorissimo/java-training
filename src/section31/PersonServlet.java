package section31;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/person")
public class PersonServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    PersonServiceBeanLocal personService;

    public PersonServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String method = request.getParameter("method") != null ? request.getParameter("method") : "";

        if(method.equals("add")) {
            Person p = new Person();
            p.setName("Mario");
            p.setSurname("Rossi");
            p.setAge(40);
            
            personService.savePerson(p);
        } else if(method.equals("get")){
            Long id = Long.parseLong(request.getParameter("id"));
            Person p = personService.getPersonById(id);
            response.getWriter().println(p.getSurname() + " " + p.getName());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
