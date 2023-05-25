package ajax.mvc.handler;


import ajax.mvc.entity.Dog;
import ajax.mvc.entity.Type;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/24 19:34
 **/
//自定义结果集处理器
public class DogHandler<T> implements ResultSetHandler<List<T>> {
    //处理器操作的方法

    @Override
    public List<T> handle(ResultSet resultSet) throws SQLException {
        Dog dog = null;
        List<Dog> list = new ArrayList<>();
        //手动处理查询到的结果
        while (resultSet.next()){
            dog = new Dog();
            //获取到dog的信息进行赋值
            dog.setId(resultSet.getInt(1));
            dog.setName(resultSet.getString(2));
            dog.setAge(resultSet.getInt(3));
            dog.setSex(resultSet.getString(4));
            dog.setTypeId(resultSet.getInt(5));
            //类型相关的东西
            Type type = new Type();
            type.setTypeId(resultSet.getInt(5));
            type.setTypeName(resultSet.getString(6));
            //将type对象赋值给dog的type属性；
            dog.setType(type);
            list.add(dog);
        }
            return (List<T>) list;
    }
}
