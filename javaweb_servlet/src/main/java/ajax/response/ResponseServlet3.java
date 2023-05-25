package ajax.response; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/28 10:39
 **/

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/rs03")
public class ResponseServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应一个图片到浏览器

        //先准备一个图片
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\asus\\Pictures\\Camera Roll\\love.jpg");
        //将文件输入的流复制到输出流

        //1.字节输出流
        ServletOutputStream outputStream = response.getOutputStream();

        //定义一个数组，存储每次从流中读取的字节数、
        byte[] buff = new byte[1024];
        //需要循环将流中所有的字节数据读取出来
        int read = 0;
        //每次读取1024字节放入到数组中，如果没有数据了。返回-1
        while ((read = fileInputStream.read(buff)) != -1) {
            //读一次向浏览器写一次
            //2.通过字节输出流对象向浏览器输出字节流数据（二进制数据）
             outputStream.write(buff,0,read);
        }
        //3.关闭创建的输入流,response的流会自动关闭
        fileInputStream.close();
    }

}
