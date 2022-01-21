package com.javamaster.spring_firstapp.repository;

import com.javamaster.spring_firstapp.entity.Users;
import  org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {// наследование от JpaRepository обеспечивает основные операции по поиску, сохранения, удалению данных (CRUD операции)


    Users findByLogin(String login); //

}
