package com.techcenture.academy.tests;

import com.techcenture.academy.utils.Machine;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by tairovich_jr on 2022-01-20.
 */
public class MachineTests {

    Machine machine;

    @BeforeMethod
    public void setUp(){
        machine = new Machine();
    }

    @Test
    public void addTwoNumbersTest(){
        int actual = machine.addTwoValues(2,2);
        Assert.assertEquals(4, actual);
    }

    @Test
    public void addTwoNumbersNegTest(){
        int actual = machine.addTwoValues(2, 2);
        Assert.assertNotEquals(3,actual);
    }
}
