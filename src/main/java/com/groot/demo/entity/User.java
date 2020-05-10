package com.groot.demo.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true)
    private String userId;

    @Column
    private String password;

    @Column
    private String userName;

    @Builder
    public User(String userId, String password, String userName) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
    }

    public boolean isSamePassword(String password) {
        if (this.password.equals(password)) {
            return true;
        }

        return false;
    }

}
