package ajax.crud.servlet; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/8 10:40
 **/

import ajax.crud.entity.Employee;
import ajax.crud.service.EmployeeService;
import ajax.crud.service.impl.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/findall")
public class ListServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        List<Employee> byall = employeeService.findByAll();
        if (byall !=null){
            //将数据存储到域对象中显示在页面上
            request.setAttribute("empList",byall);
            request.getRequestDispatcher("/employeeList.jsp").forward(request,response);
        }else {
            response.getWriter().write("抱歉，发生一些错误了呢！！");
        }

    }
}
