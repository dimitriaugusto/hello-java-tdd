package com.dimiaug.hello.tdd.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack stack = new Stack();

    @Test
    public void canCreateStack() throws Exception {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void afterOnePush_isNotEmpty() throws Exception {
        stack.push(0);
        Assertions.assertFalse(stack.isEmpty());
        assertEquals(1, stack.getSize());
    }

    @Test
    public void afterOnePushAndOnePop_shouldBeEmpty() throws Exception {
        stack.push(0);
        stack.pop();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    @Test
    public void afterTwoPushed_sizeIsTwo() throws Exception {
     stack.push(0);
     stack.push(0);
     assertEquals(2, stack.getSize());
    }

    @Test
    public void poppingEmptyStack_throwsUnderflow() throws Exception {
        assertThrows(Stack.Underflow.class, ()-> stack.pop());
    }

    @Test
    public void afterPushingX_willReturnX() throws Exception {
        stack.push(99);
        assertEquals(99, stack.pop());
        stack.push(88);
        assertEquals(88, stack.pop());
    }

    @Test
    public void afterPushingXandY_willPopYthenX() throws Exception {
        stack.push(99);
        stack.push(88);
        assertEquals(88, stack.pop());
        assertEquals(99, stack.pop());
    }
}
