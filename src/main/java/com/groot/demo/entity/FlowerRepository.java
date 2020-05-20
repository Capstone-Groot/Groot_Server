package com.groot.demo.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<User, Long> {
}
