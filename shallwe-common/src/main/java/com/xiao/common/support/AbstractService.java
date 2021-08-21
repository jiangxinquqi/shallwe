package com.xiao.common.support;

import java.util.List;

/**
 * 服务层抽象实现
 * <p>
 *
 * @author： jianjun.xiao
 * @e-mail： xiaocen65535@163.com
 * @date： 2021/8/11 16:09
 */
public class AbstractService<I, D extends BaseDO<I>> implements BaseService<I, D> {

    protected BaseMapper<I, D> baseMapper;

    public AbstractService(BaseMapper baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public void add(D baseDO) {
        baseMapper.insert(baseDO);
    }

    @Override
    public void addSelective(D baseDO) {
        baseMapper.insertSelective(baseDO);
    }

    @Override
    public void deleteById(I id) {
        baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateById(D baseDO) {
        baseMapper.updateByPrimaryKey(baseDO);
    }

    @Override
    public void updateByIdSelective(D baseDO) {
        baseMapper.updateByPrimaryKeytSelective(baseDO);
    }

    @Override
    public D getById(I id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<D> listBySelective(D baseDO) {
        return baseMapper.listBySelective(baseDO);
    }
}
