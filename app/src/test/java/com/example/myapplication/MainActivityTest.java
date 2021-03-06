package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest   {


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



    @Test(expected = ArithmeticException.class)
    public void ExceptionTest() throws Exception {
        Calculater calculater= new Calculater();
        String a = String.valueOf(Double.MAX_VALUE)+1;
        String b=a;
        calculater.cal(a,b,"+");
    }




    @Test
    public void InvalidInput1() throws Exception {
        Calculater calculater=new Calculater();
        assertEquals(0,calculater.cal("1...11111","1","-"),0);
    }

    @Test
    public void InvalidInput2() throws Exception {
        Calculater calculater=new Calculater();
        assertEquals(-1,calculater.cal("...11111","1","-"),0);
    }


}