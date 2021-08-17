package com.xiao.common.support;

import java.util.List;

/**
 * @desc: 功能描述：<持久层抽象>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/8/8 16:43
 */
public interface BaseMapper<I, D extends BaseDO> {

    int insert(D baseDO);

    int insertSelective(D baseDO);

    int deleteByPrimaryKey(I id);

    int updateByPrimaryKey(D baseDO);

    int updateByPrimaryKeytSelective(D baseDO);

    D selectByPrimaryKey(I id);

    List<D> listBySelective(D baseDO);

}
