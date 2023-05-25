package ajax.login.web; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/10 10:54
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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
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

        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String borntime = request.getParameter("borntime");
        String sex = request.getParameter("sex");
        int gradeId = Integer.parseInt(request.getParameter("grade.gradeId"));
        String grade = request.getParameter("grade");
        //String gradeName = request.getParameter("grade.gradeName");
        //Grade grade =new Grade(gradeId,gradeName);
        Student student = new Student(id,name, borntime, sex, gradeId);
        boolean up = studentService.update(student);
        //boolean upgrade=gradeService.update(grade);
        if (up){

            //重定向
            response.sendRedirect(request.getContextPath()+"/list");
        }else {
            //失败的操作
            request.setAttribute("msg","数据提交失败");
            request.getRequestDispatcher("/update").forward(request,response);
        }
    }
}
