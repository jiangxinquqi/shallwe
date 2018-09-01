package com.xiao.user.api.controller;

import com.xiao.common.util.StringUtils;
import com.xiao.common.vo.JsonView;
import com.xiao.user.api.UserApi;
import com.xiao.user.dao.model.UserMock;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 功能描述：（用户微服务实现）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/1 20:19
 */
@RestController
public class UserServiceController implements UserApi {

    private static final Map<Long, UserMock> userServiceMock = new HashMap<>();

    private static final Map<String, Long> redisMock = new HashMap<>();

    static {
        userServiceMock.put(1L, new UserMock(1L, "xiao", "xiao", new Date(), new Date()));
        userServiceMock.put(2L, new UserMock(2L, "jian", "jian", new Date(), new Date()));
    }

    @Override
    public JsonView register(@RequestBody UserMock userMock) {
        userServiceMock.put(userMock.getId(), userMock);
        return JsonView.sucess(userMock);
    }

    @Override
    public JsonView login(@RequestParam(value = "username") String username,
                          @RequestParam(value = "password") String password) {
        // 根据用户名查询用户
        UserMock userMock = login(username);
        // 生成token并且设置过期时间，并返回token
        String token = StringUtils.UUID();
        redisMock.put(token, userMock.getId());
        return JsonView.sucess(token);
    }

    @Override
    public JsonView info(@RequestParam(value = "token") String token) {
        // 根据token查询userid
        Long userid = redisMock.get(token);
        // 根据userid查询用户信息,并且返回
        return JsonView.sucess(userServiceMock.get(userid));
    }

    private UserMock login(String username) {
        if ("xiao".equals(username)) {
            return userServiceMock.get(1L);
        } else {
            return userServiceMock.get(2L);
        }
    }
}
