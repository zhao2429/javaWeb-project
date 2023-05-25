package ajax.login.dao;

import ajax.login.entity.User;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 9:15
 **/
public interface UserDao {


    /**
     * 根据用户名和密码查询用户信息
     * @param user  查询时传入的条件对象
     * @return  查询后用户的对象信息
     */
    User selectByUserAndPassWord(User user);

    /**
     * 注册功能
     * @param user
     * @return
     */

    int insert(User user);

    List<User> selectUserName(User user);

}
