package ajax.login.service.impl;

import ajax.login.dao.UserDao;
import ajax.login.dao.impl.UserDaoImpl;
import ajax.login.entity.User;
import ajax.login.service.UserService;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 9:32
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(User user) {
        return userDao.selectByUserAndPassWord(user);
    }

    @Override
    public boolean zhuce(User user) {
        return userDao.insert(user) > 0;
    }

    @Override
    public List<User> find(User user) {
        return userDao.selectUserName(user);
    }
}
