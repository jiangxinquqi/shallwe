package com.xiao.common.support;

import java.util.Date;

/**
 * @desc: 功能描述：<BaseDO>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/8/8 16:28
 */
public abstract class BaseDO<I> {

    private I id;
    private Date createTime;
    private Date modifiedTime;

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
