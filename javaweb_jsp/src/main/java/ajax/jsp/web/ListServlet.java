package ajax.jsp.web; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/5 15:46
 **/

import ajax.jsp.entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        List<Student> students = new ArrayList<Student>();
        //遍历循环
//        for (int i=1;i<=10;i++){
//            students.add(new Student("name")+i);
//        }
        students.add(new Student("张三"));
        students.add(new Student("李四"));
        students.add(new Student("小明"));
        students.add(new Student("小红"));
        students.add(new Student("王五"));
        students.add(new Student("大白"));
        students.add(new Student("小白"));
        students.add(new Student("麻子"));
        students.add(new Student("小小"));
        request.setAttribute("students",students);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
