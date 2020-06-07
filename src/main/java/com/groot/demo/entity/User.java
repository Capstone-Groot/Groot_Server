package com.groot.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Getter
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

    @Column
    private String sellerCheck;

    @Builder
    public User(String userId, String password, String userName, String sellerCheck) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.sellerCheck = sellerCheck;
    }

    public boolean isSamePassword(String password) {
        if (this.password.equals(password)) {
            return true;
        }

        return false;
    }

    public boolean isSameUser(String userId) {
        return this.userId.equals(userId);
    }

}
