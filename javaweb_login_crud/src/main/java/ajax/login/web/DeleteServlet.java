package ajax.login.web; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/10 11:00
 **/

import ajax.login.entity.Student;
import ajax.login.service.GradeService;
import ajax.login.service.StudentService;
import ajax.login.service.impl.GradeServiceImpl;
import ajax.login.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private StudentService studentService= new StudentServiceImpl();
    private GradeService gradeService = new GradeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        Student student = new Student();
        student.setId(Integer.parseInt(id));

        boolean remove = studentService.delete(student);
        if (remove){
            //成功
            response.sendRedirect(request.getContextPath()+"/list");
        }else {
            //失败
            response.getWriter().write("内部发生一点错误了呢！！！");
        }
    }
}
