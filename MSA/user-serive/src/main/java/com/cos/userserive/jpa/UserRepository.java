package com.cos.userserive.jpa;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {


    UserEntity findByEmail(String username);
}
