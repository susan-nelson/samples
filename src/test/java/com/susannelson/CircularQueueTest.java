package com.susannelson;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CircularQueueTest {

    @Test
    public void testSize() throws Exception {

        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(5);

        assertTrue(circularQueue.size() == 0);

        circularQueue.offer(11);
        circularQueue.offer(21);

        assertTrue(circularQueue.size() == 2);
    }

    @Test
    public void testIsEmpty() throws Exception {

        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(5);

        assertTrue(circularQueue.isEmpty());

        circularQueue.offer(11);

        assertFalse(circularQueue.isEmpty());
    }

    @Test
    public void testOffer() throws Exception {

        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(5);

        circularQueue.offer(11);
        circularQueue.offer(21);
        circularQueue.offer(31);
        circularQueue.offer(51);
        circularQueue.offer(61);

        assertTrue(circularQueue.size() == 5);
    }

    @Test
    public void testOffer_false() throws Exception {

        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(5);

        circularQueue.offer(11);
        circularQueue.offer(21);
        circularQueue.offer(31);
        circularQueue.offer(51);
        boolean lastOffer = circularQueue.offer(61);

        assertTrue(lastOffer);

        lastOffer = circularQueue.offer(71);

        assertFalse(lastOffer);
        assertTrue(circularQueue.size() == 5);
    }


    @Test
    public void testOffer_wrap() throws Exception {

        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(5);

        circularQueue.offer(11);
        circularQueue.offer(21);
        circularQueue.offer(31);
        circularQueue.offer(51);
        circularQueue.offer(61);

        assertTrue(circularQueue.poll() == 11);
        assertTrue(circularQueue.size() == 4);

        circularQueue.offer(71);

        assertTrue(circularQueue.size() == 5);

        assertTrue(circularQueue.poll() == 21);
        assertTrue(circularQueue.size() == 4);

        circularQueue.offer(81);

        assertTrue(circularQueue.size() == 5);
    }

    @Test
    public void testPoll() throws Exception {

        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(5);

        circularQueue.offer(11);
        circularQueue.offer(21);
        circularQueue.offer(31);
        circularQueue.offer(51);
        circularQueue.offer(61);

        assertTrue(circularQueue.size() == 5);

        assertTrue(circularQueue.poll() == 11);
        assertTrue(circularQueue.poll() == 21);
        assertTrue(circularQueue.poll() == 31);
        assertTrue(circularQueue.poll() == 51);
        assertTrue(circularQueue.poll() == 61);
    }

    @Test
    public void testPeek() throws Exception {

        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(5);

        circularQueue.offer(11);
        circularQueue.offer(21);

        assertTrue(circularQueue.size() == 2);
        assertTrue(circularQueue.peek() == 11);
        assertTrue(circularQueue.peek() == 11);
    }
}