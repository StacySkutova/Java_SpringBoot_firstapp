package com.javamaster.spring_firstapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users_table") //таблица из бд
@Data//lombok аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//lombok аннотация: конструктор без аргуметов
public class Users { // класс оторбражения сущности
//поля аннотации java persistence: Table, Entity, Column, Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //вид стратегии генерации первичного ключа обычно известен как саморазвитие первичного ключа
    private Integer id; // поля из таблицы

    @Column
    private String name;

    @Column
    private String login;

    @Column
    private String email;

}
