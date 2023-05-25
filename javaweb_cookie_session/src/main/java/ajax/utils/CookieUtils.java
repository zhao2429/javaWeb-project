package ajax.utils;

import javax.servlet.http.Cookie;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/10 15:31
 **/

//cookie的工具类
public class CookieUtils {
    /**传入所有的cookie数组查找指定的cookie
     *
     * @param cookies 被查找的数组
     * @param cookieName 要找的cookie名字
     * @return 返回找到的cookie对象
     */
    public static  Cookie findCookie(Cookie[] cookies,String cookieName){
        //如果cookie的数组，名字，长度都为零，则返回空
        if (cookieName == null || cookies ==null || cookies.length ==0){
            return  null;
        }
        //
        for (Cookie cookie: cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie;
            }
        }



        return null;
    }
}
