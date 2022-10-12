package com.dimiaug.hello.tdd.queue;

import com.dimiaug.hello.tdd.queue.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @Test
    public void canCreateQueue() throws Exception {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void canPush() throws Exception {
        queue.push(0);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
    }

    @Test
    public void pushingX_willPopX() throws Exception {
        queue.push(99);
        assertEquals(99, queue.pop());
        queue.push(88);
        assertEquals(88, queue.pop());
    }

    @Test
    public void pushingXthenY_popsXthenY() throws Exception {
        queue.push(99);
        queue.push(88);
        assertEquals(99, queue.pop());
        assertEquals(88, queue.pop());
    }

    @Test
    public void pushingXthenYthenZ_popsXthenYthenZ() throws Exception {
        queue.push(99);
        assertEquals(99, queue.pop());
        queue.push(88);
        queue.push(77);
        assertEquals(88, queue.pop());
        assertEquals(77, queue.pop());
        queue.push(66);
        assertEquals(66, queue.pop());
    }

    @Test
    public void poppingEmptyQueue_throwsQueueUnderflow() throws Exception {
        assertThrows(
                Queue.QueueUnderflow.class, () -> {
                    queue.push(0);
                    queue.pop();
                    queue.pop();
                }
        );
    }

    @Test
    public void popping3elements_throwsQueueOverflow() throws Exception {
        assertThrows(
                Queue.QueueOverflow.class,
                () -> {
                    queue.push(0);
                    queue.push(0);
                    queue.push(0);
                }
        );
    }
}
