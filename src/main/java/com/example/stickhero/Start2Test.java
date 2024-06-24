package com.example.stickhero;
import org.junit.*;
//import static org.junits.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Start2Test {
    @Test
    public void testStick(){
        if(Start2.isStickFell())Assert.assertTrue(Start2.isValidStick());
    }

    @Test
    public void testCherryCollection(){
        if(Start2.isCherryIncremented())Assert.assertTrue(Start2.isStickmanIntersects());
    }

    @Test
    public void testStickmanOrientation(){
        if(Start2.isCherryIncremented())Assert.assertTrue(Start2.isStickmanIsFlipped());
    }

    @Test
    public void testSingletonStickman(){
        stickHero s1 = stickHero.getInstance();
        stickHero s2 = stickHero.getInstance();

        Assert.assertEquals(s1, s2);
    }


}



