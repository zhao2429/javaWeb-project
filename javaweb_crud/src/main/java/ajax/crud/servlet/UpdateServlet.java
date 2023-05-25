package ajax.crud.servlet; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/8 16:25
 **/

import ajax.crud.entity.Employee;
import ajax.crud.service.EmployeeService;
import ajax.crud.service.impl.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/updateEmployee")
public class UpdateServlet extends HttpServlet {
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
        int id = Integer.parseInt(request.getParameter("id"));

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //使用拆箱
        int age = Integer.parseInt(request.getParameter("age"));
        String phone = request.getParameter("phone");
        int status = Integer.parseInt(request.getParameter("status"));

        Employee employee = new Employee(id,username,password,age,phone,status);

        boolean modify = employeeService.modify(employee);

        if (modify) {
            //成功
            response.sendRedirect(request.getContextPath()+"/findall");
        }else {
            //失败
            response.getWriter().write("数据修改发生了一些问题了呢！！！");
        }
    }
}
