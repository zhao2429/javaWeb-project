package ajax.mvc.dao.impl;

import ajax.mvc.entity.Type;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/25 20:42
 **/
public class TypeDaoImpl extends BaseDao implements  TypeDao{
    @Override
    public Type getTypeById(Type type) {
        String sql = "select * from type where typeid = ?";
        return selectByOne(Type.class,sql,type.getTypeId());
    }
}
