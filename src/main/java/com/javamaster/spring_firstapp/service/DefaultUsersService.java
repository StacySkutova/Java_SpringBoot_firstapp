package com.javamaster.spring_firstapp.service;

import com.javamaster.spring_firstapp.dto.UsersDto;
import com.javamaster.spring_firstapp.entity.Users;
import com.javamaster.spring_firstapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors; //универсальная работа с данными
import javax.xml.bind.ValidationException;

import static java.util.Objects.isNull;


@Service // внедрение контроллера
@AllArgsConstructor //
//реализация методов из UsersService
public class DefaultUsersService implements UsersService {

    //внедрение зависимости через конструктор
    private final UserRepository usersRepository;
    private final UserConverter usersConverter;

    @Override
    //На вход будет приходить UsersDto объект.
    // Мы должны провалидировать данные, создать объект Users и переместить данные из UsersDto в Users.
    // Только после этого мы можем сохранить нового польозвателя в базу данных.
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        Users savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);
    }
    //если объект Null — выбрасываем ValidationException с информацией,
    //если логин нул или пустой — выбрасываем ValidationException и указываем что логин пустой
    //если емейл нул или пустой — выбрасываем ValidationException и указываем что емейл пустой
    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
        if (isNull(usersDto.getEmail()) || usersDto.getEmail().isEmpty()) {
            throw new ValidationException("Email is empty");
        }
    }
    //удаление по id
    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    //если пользователь найден конверт в дто, если нет нал
    @Override
    public UsersDto findByLogin(String login) {
        Users users = usersRepository.findByLogin(login);
        if (users != null) {
            return usersConverter.fromUserToUserDto(users);
        }
        return null;
    }
    //вынимаем всех пользователей из бд и конвентируем в список дто
    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }
}