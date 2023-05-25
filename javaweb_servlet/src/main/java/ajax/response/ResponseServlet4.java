package ajax.response; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/28 10:39
 **/

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/rs04")
public class ResponseServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用IOoutils工具类完成流的复制


        //1：先准备一个图片
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\asus\\Pictures\\Camera Roll\\love.jpg");
        //将文件输入的流复制到输出流

        //2.获取字节输出流
        ServletOutputStream outputStream = response.getOutputStream();

        //3：使用工具类完成流的复制（复制中已经进行了字节流的输出）
        IOUtils.copy(fileInputStream,outputStream);
        //4:创建关闭
        outputStream.close();


    }

}
