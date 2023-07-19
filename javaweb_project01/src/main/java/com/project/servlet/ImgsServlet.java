package com.project.servlet; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/14 20:52
 **/

import com.project.entity.Course;
import com.project.service.CourseService;
import com.project.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;


@WebServlet("/upload")
//@MultipartConfig标注主要是为了辅助Servlet3.0中HttpServletRequest提供的对上传文件的支持
@MultipartConfig
public class ImgsServlet extends HttpServlet {
    private CourseService corseService = new CourseServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        String uploadPath = getServletContext().getRealPath("/uploads"); // 上传文件存储的目录
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        List<Part> parts = (List<Part>) request.getParts();
        for (Part part : parts) {
            String fileName = part.getSubmittedFileName();
            String path = uploadPath + File.separator + fileName;
            part.write(path);


            Course img = new Course();
            img.setImage(path);
            boolean add = corseService.modify(img);
            response.getWriter().write(add?"success":"error");
        }
        //response.getWriter().print("文件上传成功！");
    }
}
