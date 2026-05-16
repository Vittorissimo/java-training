package section31;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatcher {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);

        long rows = LocalCourse.userListCount();
        int resultForPage = 2;
        int p = 1;
        
        LocalCourse.userList();
        LocalCourse.assignStudentToTheCourse();
        LocalCourse.createAnAccountAssociatedWithAUser();
        LocalCourse.printInvoice();
        String greeting = LocalCourse.greeting();
        String page = request.getParameter("page");
        if(page != null && !page.trim().equals("")) {
            if (page.equals("1")) {
                request.setAttribute("object", "test");
            }
        }
    }
}
