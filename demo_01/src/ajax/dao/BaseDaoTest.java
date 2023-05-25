package ajax.dao;

import ajax.entity.DogTwo;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/24 20:18
 **/
public class BaseDaoTest {
    public static void main(String[] args) {
        BaseDao baseDao = new BaseDao();
        //定义sql
        //新增测试
        //String sql = "insert into dog values(?,?,?,?,?)";
        //int update = baseDao.update(sql, null, "小蓝", 4, "母",1);

        //测试删除
        //String sql ="delete from dog where id = ?";
        //int update = baseDao.update(sql,5);

        //测试修改
       /* String sql = "update dog set name = ? , age = ? , sex = ?,typeid = ?  where id = ?";
        //2：执行sql
        int update = baseDao.update(sql,"常威",4,"公",1,4);
        if (update > 0 ){
            System.out.println("操作成功");
        }else {
            System.out.println("操作失败");
        }*/
        
        
        //测试查询单个对象
        /*String sql = "select * from dog where id = ?";
        DogTwo dog = baseDao.selectByOne(DogTwo.class, sql, 1);
        System.out.println("dog = " + dog);*/

        //测试查询全部的对象
        String sql = "select * from dog";
        List<DogTwo> dog = baseDao.selectList(DogTwo.class, sql);
        System.out.println("dog = " + dog);

        //查询单个值的
//        String sql = "select count(*) from dog";
//        Number number = (Number) baseDao.selectForValue(sql);
//        int i = number.intValue();
//        System.out.println("i = " + i);
    }
}
