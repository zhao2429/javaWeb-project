package ajax.test;

import ajax.demo.dao.impl.BaseDao;
import ajax.demo.entity.User;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/4 20:56
 **/
public class LikeTest {
    public static void main(String[] args) {
        BaseDao baseDao = new BaseDao();
        String sql = "select * from user where username like ?";

        List<User> list = baseDao.selectForList(User.class, sql, "%三%");
        System.out.println("list = " + list);
    }
}
