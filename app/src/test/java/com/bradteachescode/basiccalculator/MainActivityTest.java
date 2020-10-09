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
    @Test
    public void add() throws Exception {
        Calculater calculater= new Calculater();
        assertEquals(2.01,calculater.cal("1.01","1.0","+"),0);
    }

    @Test
    public void sub() throws Exception {
        Calculater calculater= new Calculater();
        assertEquals(0,calculater.cal("1.01","1.01","-"),0);
    }

    @Test
    public void mult() throws Exception {
        Calculater calculater= new Calculater();
        assertEquals(1.01,calculater.cal("1.01","1.0","*"),0);
    }

    @Test
    public void div() throws Exception {
        Calculater calculater= new Calculater();
        assertEquals(1.01,calculater.cal("1.01","1.0","/"),0);
    }
}