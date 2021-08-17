package com.xiao.common.support;

/**
 * 通用处理器
 * <p>该接口为实现业务上原子能力的接口
 *
 * @author： jianjun.xiao
 * @e-mail： xiaocen65535@163.com
 * @date： 2021/8/11 15:43
 */
public interface Processor<R> {

    R process(Object... args);

}
