package ajax.dbutils_test;

import ajax.entity.DogTwo;
import ajax.entity.Type;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/24 19:34
 **/
//自定义结果集处理器
public class DogHandler<T> implements ResultSetHandler<T> {
    //处理器操作的方法

    @Override
    public T handle(ResultSet resultSet) throws SQLException {
        DogTwo dog = null;
        //手动处理查询到的结果
        if (resultSet.next()){
            dog = new DogTwo();
            //获取到dog的信息进行赋值
            dog.setId(resultSet.getInt(1));
            dog.setName(resultSet.getString(2));
            dog.setAge(resultSet.getInt(3));
            dog.setSex(resultSet.getString(4));

            //类型相关的东西
            Type type = new Type();
            type.setTypeId(resultSet.getInt(5));
            type.setTypeName(resultSet.getString(6));
            //将type对象赋值给dog的type属性；
            dog.setType(type);
        }
        return (T) dog;
    }
}
