package com.bradteachescode.basiccalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainActivityTest {

    /* Initial test for TDD */
    @Test
    public void addPoint() {
        Calculater calculater= new Calculater();
        assertEquals("1.",calculater.addNumber(".","1"));
    }

}