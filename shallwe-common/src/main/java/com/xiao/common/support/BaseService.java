package com.xiao.common.support;

import com.xiao.common.vo.PageBean;

import java.util.List;

/**
 * @desc: 功能描述：<服务层抽象>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/8/8 16:34
 */
public interface BaseService<I, D extends BaseDO<I>> {

    void add(D baseDO);

    void addSelective(D baseDO);

    void deleteById(I id);

    void updateById(D baseDO);

    void updateByIdSelective(D baseDO);

    D getById(I id);

    List<D> listBySelective(D baseDO);

    default void save(D baseDO) {
        if (null != getById(baseDO.getId())) {
            updateById(baseDO);
        } else {
            add(baseDO);
        }
    }

}
