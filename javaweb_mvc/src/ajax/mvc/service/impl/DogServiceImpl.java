package ajax.mvc.service.impl;

import ajax.mvc.dao.DogDao;
import ajax.mvc.dao.impl.DogDapImpl;
import ajax.mvc.entity.Dog;
import ajax.mvc.service.DogService;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/26 19:52
 **/
public class DogServiceImpl implements DogService {
    //dao已经做好了所有的方法，只需要组合调用即可
    //上层调用下层
    private DogDao dogDao = new DogDapImpl();

    @Override
    public boolean add(Dog dog) {
        return dogDao.insert(dog) > 0;
    }

    @Override
    public boolean remove(Dog dog) {
        return dogDao.detele(dog) > 0;

    }

    @Override
    public boolean modify(Dog dog) {
        return dogDao.update(dog) > 0;
    }

    @Override
    public Dog findById(Dog dog) {
        return dogDao.selectById(dog);
    }

    @Override
    public List<Dog> findByAll() {
        return dogDao.selectAll();
    }
}
