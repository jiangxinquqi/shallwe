package com.xiao.user.api.feign;

import com.xiao.common.constant.ServerCode;
import com.xiao.common.vo.JsonView;
import com.xiao.user.dao.model.UserMock;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/1 20:27
 */
public class UserServiceHystric implements UserServiceFeign {

    @Override
    public JsonView register(@RequestBody UserMock userMock) {
        return new JsonView(ServerCode.SERVER_CODE_500, null);
    }

    @Override
    public JsonView login(String username, String password) {
        return new JsonView(ServerCode.SERVER_CODE_500, null);
    }

    @Override
    public JsonView info(@RequestParam(value = "token") String token) {
        return new JsonView(ServerCode.SERVER_CODE_500, null);
    }

}
