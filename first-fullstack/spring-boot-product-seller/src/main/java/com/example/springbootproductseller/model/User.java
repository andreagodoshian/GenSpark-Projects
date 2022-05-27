package com.example.springbootproductseller.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name="password", unique = true, nullable = false, length = 50)
    private String password;

    @Column(name="name", unique = true, nullable = false)
    private String name;

    @Column(name="create_time", unique = true, nullable = false)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable = false)
    private Role role;

}
