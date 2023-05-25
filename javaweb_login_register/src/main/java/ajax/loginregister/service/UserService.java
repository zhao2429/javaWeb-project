package ajax.loginregister.service;


import ajax.loginregister.entity.User;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/4 10:11
 **/

//业务逻辑层
public interface UserService {
    /**
     * 业务层登录的方法
     * @param user  需要验证的用户信息
     * @return   返回查询后的用户信息
     */
    User login(User user);

    User exists(User user);

    /**
     * 用户注册的方法
     * @param user 需要注册的用户信息
     * @return 注册是否成功
     */
    boolean reg(User user);

    List<User> find(User user);
}
