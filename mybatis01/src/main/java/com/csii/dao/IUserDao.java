package com.csii.dao;

import com.csii.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> queryAll();
}
