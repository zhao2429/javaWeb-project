package ajax.mvc.dao.impl;

import ajax.mvc.entity.Type;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/25 20:40
 **/
//设计type的底层功能
public interface TypeDao {
    /**
     * 根据id查询type的信息
     * @param type 查询条件为type
     * @return 查询完返回type的信息
     */
    Type getTypeById(Type type);
}
