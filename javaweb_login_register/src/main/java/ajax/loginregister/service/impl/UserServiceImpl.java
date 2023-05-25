package ajax.loginregister.service.impl;


import ajax.loginregister.dao.UserDao;
import ajax.loginregister.service.UserService;
import ajax.loginregister.dao.impl.UserDaoImpl;
import ajax.loginregister.entity.User;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/4 10:14
 **/
public class UserServiceImpl implements UserService {
    //UserServiceImpl访问dao实现
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.selectByUserAndPassWord(user);
    }

    @Override
    public User exists(User user) {
        return userDao.selectByUser(user);
    }

    @Override
    public boolean reg(User user) {
        //受影响行数 如果大于0就是成功

        return userDao.insert(user) > 0;
    }

    @Override
    public List<User> find(User user) {
        return userDao.selectUserName(user);
    }
}
