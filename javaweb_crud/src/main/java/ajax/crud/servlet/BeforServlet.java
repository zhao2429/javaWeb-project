package ajax.crud.servlet; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/8 16:08
 **/

import ajax.crud.service.EmployeeService;
import ajax.crud.service.impl.EmployeeServiceImpl;
import ajax.crud.entity.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectById")
public class BeforServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
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
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(id));
        Employee byId = employeeService.findById(employee);

        if(byId!=null){
            //查询到数据,携带数据显示到编辑页面上
            request.setAttribute("employee",byId);
            request.getRequestDispatcher("/employeeDel.jsp").forward(request,response);

        }else {
            //同步错误
            response.getWriter().write("数据查询发生了一下错误了呢！");
        }
    }
}
