package ajax.crud.servlet; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/8 15:27
 **/

import ajax.crud.service.EmployeeService;
import ajax.crud.service.impl.EmployeeServiceImpl;
import ajax.crud.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletaById")
public class DeleteServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(id));

        boolean remove = employeeService.remove(employee);
        if (remove){
            //成功
            response.sendRedirect(request.getContextPath()+"/findall");

        }else {
            //失败
            response.getWriter().write("内部发生一点错误了呢！！！");
        }

    }
}
