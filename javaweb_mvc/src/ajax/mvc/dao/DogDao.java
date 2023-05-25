package ajax.mvc.dao;

import ajax.mvc.entity.Dog;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/25 18:44
 **/
public interface DogDao {
    //设计操作Dog的相关底层功能，提供给以后统筹整个功能的类的使用
    //通常都是设计增删改查


    /**
     * 新增Dog的抽象方法
     * @param dog 参数 通过传入Dog对象，灵活的插入传入的值
     * @return 返回执行后受影响的行数
     */
    public int insert(Dog dog);


    /**
     * 删除Dog的抽象方法
     * @param dog 参数 通过传入Dog对象，灵活的插入传入的值
     * @return 返回执行后受影响的行数
     */
    public int detele(Dog dog);


    /**
     * 修改Dog的抽象方法
     * @param dog 参数 通过传入Dog对象，灵活的插入传入的值
     * @return 返回执行后受影响的行数
     */
    public int update(Dog dog);

    /**
     * 根据id查询dog信息
     * @param dog 传入的dog对象
     * @return 查询后的完整dog信息
     */
    public Dog selectById(Dog dog);

    /**
     * 查询全部的dog信息的方法
     * @return
     */
    List<Dog> selectAll();

    //根据业务逻辑的需要可能还需要其他的方法


}
