package ajax.login.web; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 16:03
 **/

import ajax.login.service.StudentService;
import ajax.login.service.impl.StudentServiceImpl;
import ajax.login.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        List<Student> students = studentService.selectList();
        if(students != null){
            request.setAttribute("student",students);
            //
           request.getRequestDispatcher("/info.jsp").forward(request,response);

        }else {
            response.getWriter().write("非常抱歉的呢，系统发生一些错误了呢！！");
        }
    }
}
