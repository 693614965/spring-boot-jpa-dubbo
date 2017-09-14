package com.gaofeng.demo.api.user;

import com.gaofeng.demo.api.user.entity.UserEntity;

import java.util.List;

public interface UserService {

    void add(UserEntity userEntity) throws Exception;

    List<UserEntity> list(int page, int pageSize, UserEntity userEntity) throws Exception;
}
