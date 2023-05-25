package ajax.login.web; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/10 11:32
 **/

import ajax.login.entity.Student;
import ajax.login.service.StudentService;
import ajax.login.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectById")
public class BeforServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询修改之前的信息
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取id
        String id = request.getParameter("id");
        Student student = new Student();
        student.setId(Integer.parseInt(id));
        Student byId = studentService.selectById(student);

        if(byId!=null){
            //查询到数据,携带数据显示到编辑页面上
            request.setAttribute("stu",byId);
            request.getRequestDispatcher("/update.jsp").forward(request,response);

        }else {
            //同步错误
            response.getWriter().write("数据查询发生了一下错误了呢！");
        }
    }
}
