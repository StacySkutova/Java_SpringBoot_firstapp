package com.javamaster.spring_firstapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

@Data //— генерирует геттеры, сеттеры
@Builder //
@AllArgsConstructor //  генерирует конструктор для всех полей класса

public class UsersDto {// DTO — это простой java класс, который служит для передачи данных между слоями
//Именно в этот класс мы будем превращать нашу сущность юзер когда достанем данные из базы. Также этот класс будет нам служить трансфером между клиентом, контроллером и сервисом.
    @Id
    @GeneratedValue
    private Integer id;
    private String name; //будут такие же поля как и в нашей сущности User
    private String login;
    private String email;
}

