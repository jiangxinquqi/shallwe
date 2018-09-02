package com.xiao.user.dao.mapper;

import com.xiao.user.dao.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @desc: 功能描述：（用户持久层）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/2 9:12
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user values(null,#{phone},#{username},#{password})")
    int insert(User user);

    @Delete("delete from user where id=#{id}")
    int delete(Long id);

    @Update("update user set phone= #{phone} where id = #{id}")
    int update(User user);

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Long id);


}
