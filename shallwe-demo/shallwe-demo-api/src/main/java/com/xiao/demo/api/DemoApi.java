package com.xiao.demo.api;

import com.xiao.common.vo.RestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc: 功能描述：（演示接口）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/31 13:27
 */
public interface DemoApi {

    @GetMapping("/demo")
    RestResponse findDemoById(@RequestParam(value = "id", required = true) int id);

}
