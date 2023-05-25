package ajax.login.dao.impl;

import ajax.login.dao.UserDao;
import ajax.login.entity.User;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 9:19
 **/
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User selectByUserAndPassWord(User user) {
        String sql = "select * from user where username = ? and password = ? ";
        return  selectForOne(User.class,sql,user.getUsername(),user.getPassword());
    }

    @Override
    public int insert(User user) {
        String sql = "insert into user(username,password) values(?,?)";
        return update(sql,user.getUsername(),user.getPassword());
    }

    @Override
    public List<User> selectUserName(User user) {
        String sql = "select * from user where username like ?";
        return selectForList(User.class,sql,"%"+user.getUsername()+"%");
    }
}
