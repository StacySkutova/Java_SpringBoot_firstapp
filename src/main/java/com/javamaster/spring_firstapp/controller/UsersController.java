package com.javamaster.spring_firstapp.controller;

import com.javamaster.spring_firstapp.dto.UsersDto;
import com.javamaster.spring_firstapp.exception.ValidationException;
import com.javamaster.spring_firstapp.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // указывает спринг что этот класс представляет рест апи
@RequestMapping("/users") //указыв что адреса всех методов которые есть в классе будут начит с
@AllArgsConstructor
@Log //включение логирования
@CrossOrigin
public class UsersController //обработка запросов по работе с сущностью User
 {
//внедрение зависимостей через конструктор  что бы вызывать методы по удалению созданию и тд
    private final UsersService usersService;
//post http метод
    @PostMapping("/save") //путь за который отвечает метод
    public UsersDto saveUsers(@RequestBody UsersDto usersDto) throws ValidationException, javax.xml.bind.ValidationException {
        log.info("Handling save users: " + usersDto);
        try {
            return usersService.saveUser(usersDto);
        } catch (javax.xml.bind.ValidationException e) {
            e.printStackTrace();
        }
        return usersService.saveUser(usersDto);
    }
//get -//-
    @GetMapping("/findAll")
    public List<UsersDto> findAllUsers() {
        log.info("Handling find all users request");
        return usersService.findAll();
    }
//get -//-
    @GetMapping("/findByLogin")
    public UsersDto findByLogin(@RequestParam String login) {
        log.info("Handling find by login request: " + login);
        return usersService.findByLogin(login);
    }
//delete -//-
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        log.info("Handling delete user request: " + id);
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
