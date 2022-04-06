package com.mycrud.crudapi.dao;

import com.mycrud.crudapi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}
