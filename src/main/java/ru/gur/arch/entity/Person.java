package ru.gur.arch.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "user_name", nullable = false)
    private String name;
}
