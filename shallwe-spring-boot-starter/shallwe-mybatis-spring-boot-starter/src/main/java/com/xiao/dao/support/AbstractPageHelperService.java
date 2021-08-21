package com.xiao.dao.support;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiao.common.constant.RestResponseCodeEnum;
import com.xiao.common.exception.GlobalException;
import com.xiao.common.support.AbstractService;
import com.xiao.common.support.BaseDO;
import com.xiao.common.support.BaseMapper;
import com.xiao.common.vo.PageBean;

/**
 * 分页抽象
 * <p>
 *
 * @author： jianjun.xiao
 * @e-mail： xiaocen65535@163.com
 * @date： 2021/8/19 8:06
 */
public class AbstractPageHelperService<I, D extends BaseDO> extends AbstractService {

    public AbstractPageHelperService(BaseMapper baseMapper) {
        super(baseMapper);
    }

    public PageInfo getPageInfo(int currentPage, int PageSize, D baseDO) {
        PageHelper.startPage(currentPage, PageSize);
        if (baseDO == null) {
            try {
                baseDO = (D) BaseDO.class.newInstance();
            } catch (Exception e) {
                throw new GlobalException(RestResponseCodeEnum.HTTP_RESPONSE_500, "创建BaseDO失败");
            }
        }
        return new PageInfo(baseMapper.listBySelective(baseDO));
    }

    public PageBean page(int currentPage, int PageSize, D baseDO) {
        PageInfo pageInfo = getPageInfo(currentPage, PageSize, baseDO);
        return new PageBean(
                pageInfo.getPageNum(),
                pageInfo.getPageSize(),
                (int) pageInfo.getTotal(),
                pageInfo.getPages(),
                pageInfo.getList());
    }

}
