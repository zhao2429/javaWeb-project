package ajax.loginregister.web.old; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/12 11:10
 **/

import ajax.loginregister.utils.CodeUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//专门用于生成图片的servlet
@WebServlet("/code.jpg")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");

        //生成验证码
        String s = CodeUtils.outputVerifyImage(150, 50, response.getOutputStream(), 4);

        //将验证码存储到session方便注册时与用户输入的验证码进行对比
        request.getSession().setAttribute("sessioncode",s);
    }
}
