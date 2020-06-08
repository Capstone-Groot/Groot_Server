package com.groot.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String explain;

    @Builder
    public Store(String name, String address, String phoneNumber, String explain) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.explain = explain;
    }
}
