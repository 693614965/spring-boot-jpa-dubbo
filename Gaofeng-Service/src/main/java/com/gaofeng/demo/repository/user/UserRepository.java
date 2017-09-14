package com.gaofeng.demo.repository.user;

import com.gaofeng.demo.api.user.entity.UserEntity;
import com.gaofeng.demo.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, String> {
}
