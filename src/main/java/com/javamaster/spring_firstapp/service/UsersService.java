package com.javamaster.spring_firstapp.service;

import com.javamaster.spring_firstapp.dto.UsersDto;
import com.javamaster.spring_firstapp.exception.ValidationException;

import java.util.List;

public interface UsersService {
//методы которые нам нужны для работы
    UsersDto saveUser(UsersDto usersDto) throws ValidationException, javax.xml.bind.ValidationException;

    void deleteUser(Integer userId );

    UsersDto findByLogin(String login);

    List<UsersDto> findAll();
}
