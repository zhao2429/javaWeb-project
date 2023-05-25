package ajax.test;

import ajax.loginregister.utils.CodeUtils;

import java.io.FileOutputStream;


/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/12 10:42
 **/
public class ComTest {
    //测试生成验证码
    public static void main(String[] args) throws Exception {
        //创建输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("f://a.jpg");
        //直接调用验证码的方法  宽度，高度，输出的文件流，验证码的长度
        CodeUtils.outputVerifyImage(100,50,fileOutputStream,4);
        System.out.println("fileOutputStream = " + fileOutputStream);


    }
}
