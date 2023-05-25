package ajax.mvc.dao.impl;

import ajax.mvc.entity.Dog;
import ajax.mvc.entity.Type;
import ajax.mvc.dao.DogDao;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/25 18:55
 **/
//DogDao的功能的实现类
public class DogDapImpl extends BaseDao implements DogDao {
    //要用到typedao的方法
    TypeDao typeDao = new TypeDaoImpl();

    //实现增删改查的方法需要调用BaseDao中的操作
    @Override
    public int insert(Dog dog) {
        String sql = "insert into dog values (?,?,?,?,?)";
        //增加的参数从参数对象中获取，由调用basedao中的操作；
        return update(sql,null,dog.getName(),dog.getAge(),dog.getSex(),dog.getType().getTypeId());
    }

    @Override
    public int detele(Dog dog) {
        String sql = "delete from dog where id = ?";
        return update(sql,dog.getId());
    }

    @Override
    public int update(Dog dog) {
        String sql = "update dog set name = ?, age = ? , sex = ? , typeid = ? where id = ?";
        return update(sql,dog.getName(),dog.getAge(),dog.getSex(),dog.getType().getTypeId(),dog.getId());
    }

    @Override
    public Dog selectById(Dog dog) {
        String sql = "select * from dog where id = ? ";
        Dog dog1 = selectByOne(Dog.class, sql, dog.getId());
        //差type，通过当前dog1 的typeid 查询type
        Type type = typeDao.getTypeById(new Type(dog1.getTypeId(), null));
        dog1.setType(type);
        return dog1;
    }

    @Override
    public List<Dog> selectAll() {
        //方式一：先查询到外键id。然后通过外键id去重新查询
        /*String sql = "select * from dog";
        //涉及多表查询，方案一：进行多步查询
        List<Dog> dogs = selectList(Dog.class, sql);
        //根据查询的typeid去分步查询type的具体内容
        for (int i = 0; i < dogs.size() ; i++){
            //获取每一条dog的id
            Integer typeId = dogs.get(i).getTypeId();
            System.out.println("typeId = " + typeId);
            //根据id查询type 调用typedaoimpl的方法
            Type type = typeDao.getTypeById(new Type(typeId, null));
            //将type赋值给每一条
            dogs.get(i).setType(type);
        }
        return dogs;*/

        //方式二：自定义结果集处理器
        String sql = "select d.* ,t.`typename` from `dog` d left join `type` t on d.typeid = t. typeid ";
        List<Dog> dogs = selectListCur(Dog.class, sql);
        return  dogs;
    }
}
