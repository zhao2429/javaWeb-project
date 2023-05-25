package ajax.mvc.test;

import ajax.mvc.entity.Dog;
import ajax.mvc.dao.DogDao;
import ajax.mvc.dao.impl.DogDapImpl;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/25 19:41
 **/
public class DaoTest {
    public static void main(String[] args) {
        DogDao dog = new DogDapImpl();
        //查询多条数据
       /* List<Dog> dogs = dog.selectAll();
        System.out.println("dogs = " + dogs);*/

        /*TypeDao typeDao = new TypeDaoImpl();
        Type type =new Type();
        type.setTypeId(2);
        typeDao.getTypeById(type);
        System.out.println("type = " + type);*/

        //查询单条数据
        Dog dog1 = dog.selectById(new Dog(1));
        System.out.println("dog1 = " + dog1);

    }
}
