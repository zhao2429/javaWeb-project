package ajax.crud.servlet; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/8 14:46
 **/

import ajax.crud.entity.Employee;
import ajax.crud.service.EmployeeService;
import ajax.crud.service.impl.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addemp")
public class AddServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //接收请求数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //使用拆箱
        int age = Integer.parseInt(request.getParameter("age"));
        String phone = request.getParameter("phone");
        int status = Integer.parseInt(request.getParameter("status"));

        Employee employee = new Employee(username,password,age,phone,status);

        //调用service
        boolean add =employeeService.add(employee);
        if (add){
            //增加成功，查询全部数据重新展示
            //转发（转发地址不变会导致多次提交）
            //request.getRequestDispatcher("/addemp").forward(request,response);
            //重定向
            response.sendRedirect(request.getContextPath()+"/findall");
        }else {
            //失败的操作
            request.setAttribute("msg","数据提交失败");
            request.getRequestDispatcher("/addemp").forward(request,response);
        }
    }
}
