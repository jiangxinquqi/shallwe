package com.xiao.common.support;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @desc: 功能描述：<BaseDO>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/8/8 16:28
 */
@Getter
@Setter
public abstract class BaseDO<I> {

    private I id;
    private Date createTime;
    private Date modifiedTime;

}
