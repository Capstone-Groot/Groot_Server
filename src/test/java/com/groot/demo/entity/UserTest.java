package com.groot.demo.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void multiplyTest() {
        assertEquals(multiply(1, 5), 5);
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}