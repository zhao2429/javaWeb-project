package ajax.mvc.service;

import ajax.mvc.entity.Dog;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/26 19:42
 **/
public interface DogService {
    //业务逻辑，，调用多个dog的方法来支持一个功能；
    //一般都是一个方法调一个dao；

    //添加信息的方法
    boolean add(Dog dog);
    //删除信息的方法
    boolean remove(Dog dog);
    //修改 信息的方法
    boolean modify(Dog dog);
    //查询单个信息
    Dog findById(Dog dog);
    //查询全部信息
    List<Dog> findByAll();

}
