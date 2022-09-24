package com.autentia.repository;

import com.autentia.entities.User;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User save(@NotNull User user);

    User findById(long id);


}
