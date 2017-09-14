package com.gaofeng.demo.service.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.gaofeng.demo.api.user.UserService;
import com.gaofeng.demo.api.user.entity.UserEntity;
import com.gaofeng.demo.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Service(group = "group", version = "1.0")
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    public void add(UserEntity userEntity) throws Exception {

        this.userRepository.saveAndFlush(userEntity);
    }

    @Override
    public List<UserEntity> list(int page, int pageSize, UserEntity userEntity) throws Exception {

        Pageable pageable = new PageRequest(page, pageSize);
        Page<UserEntity> userEntities = this.userRepository.findAll(pageable);
        return userEntities.getContent();
    }
}
