package com.xiao.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页对象
 * <p>
 *
 * @author： jianjun.xiao
 * @e-mail： xiaocen65535@163.com
 * @date： 2021/8/19 8:14
 */
@Data
public class PageBean<T> implements Serializable {

    private Integer currentPage;
    private Integer pageSize;
    private Integer total;
    private Integer totalPage;
    private T result;

    public PageBean(Integer currentPage, Integer pageSize, Integer total, T result) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
        this.totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        this.result = result;
    }

    public PageBean(Integer currentPage, Integer pageSize, Integer total, Integer totalPage, T result) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
        this.totalPage = totalPage;
        this.result = result;
    }
}
