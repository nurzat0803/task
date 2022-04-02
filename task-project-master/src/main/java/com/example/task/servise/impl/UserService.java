package com.example.task.servise.impl;

import com.example.task.entity.User;
import org.springframework.data.domain.Page;


public interface UserService {

    Page<User> findPaginated (int pageNo, int pageSize);
}
