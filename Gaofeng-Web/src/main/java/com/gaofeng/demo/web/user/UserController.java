package com.gaofeng.demo.web.user;


import com.alibaba.dubbo.config.annotation.Reference;
import com.gaofeng.demo.api.user.UserService;
import com.gaofeng.demo.api.user.entity.UserEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Reference(group = "group", version = "1.0")
    public UserService userService;

    @RequestMapping("add")
    public Map<String, Object> add() {

        Map<String, Object> map = new HashMap<String, Object>();

        try {

            UserEntity userEntity = new UserEntity();
            userEntity.setUserName("user");
            userEntity.setPassword("123456");
            this.userService.add(userEntity);

            map.put("success", true);
            map.put("id", userEntity.getId());
        } catch (Exception e) {
            e.printStackTrace();

            map.put("success", false);
            map.put("msg", "保存异常");
        }

        return map;

    }

    @RequestMapping("list/{page}/{pageSize}")
    public Map<String, Object> list(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {

        Map<String, Object> map = new HashMap<String, Object>();

        try {

            List<UserEntity> userEntities = this.userService.list(page, pageSize, null);
            map.put("success", true);
            map.put("data", userEntities);
        } catch (Exception e) {
            e.printStackTrace();

            map.put("success", false);
            map.put("msg", "查询异常");
        }

        return map;

    }

}
