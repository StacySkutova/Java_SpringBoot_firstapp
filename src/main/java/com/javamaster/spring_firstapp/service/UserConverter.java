package com.javamaster.spring_firstapp.service;

import com.javamaster.spring_firstapp.dto.UsersDto;
import com.javamaster.spring_firstapp.entity.Users;
import org.springframework.stereotype.Component;

@Component //чтобы спринг создал бин  класса UserConventer
//Это позволит использовать внедрение зависимостей (dependency injection)
//и подлючить этот класс в класс DefaultUsersService
public class UserConverter {
    //После того как UsersDto пройдет валидацию, переконвертируем его в Users:
    public Users fromUserDtoToUser(UsersDto usersDto) {
        Users users = new Users();
        users.setEmail(usersDto.getEmail());
        users.setName(usersDto.getName());
        users.setLogin(usersDto.getLogin());
        return users;
    }
//обратная конвертация с помощью анотации builder
    public UsersDto fromUserToUserDto(Users users) {
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .login(users.getLogin())
                .name(users.getName())
                .build();
    }
}
