package ajax.demo.dao;

import ajax.demo.entity.User;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/4 10:04
 **/

//dao功能接口
public interface UserDao {


    /**
     * 根据用户名和密码查询用户信息
     * @param user  查询时传入的条件对象
     * @return  查询后用户的对象信息
     */
    User selectByUserAndPassWord(User user);

    int insert(User user);
    int delete(User user);

    List<User> selectUserName(User user);
}
