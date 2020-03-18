package com.alevel.nix.java.hometask.lesson16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForwardLinkedListTest {
    ForwardLinkedList<String> fll = new ForwardLinkedList<>();

    @BeforeEach
    void setUp() {
        fll.addLast("hello");
        fll.addLast("world");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addLast() {
        fll.addLast("23");
        assertEquals("23",fll.getLast());
    }

    @Test
    void addFirst() {
        fll.addFirst("54");
        assertEquals("54",fll.getFirst());
    }

    @Test
    void newAdd() {
        fll.newAdd(1,"3");
        assertEquals("3", fll.get(1));
    }

    @Test
    void newRemove() {
        fll.newRemove(0);
        assertEquals(1,fll.size());
    }

    @Test
    void removeFirst() {
        fll.removeFirst();
        assertEquals("world",fll.getFirst());
    }

    @Test
    void removeLast() {
        fll.removeLast();
        assertEquals("hello", fll.getLast());
    }

    @Test
    void get() {
        fll.newAdd(1,"3");
        assertEquals("3", fll.get(1));
        assertEquals("hello", fll.get(0));
        assertEquals("world", fll.get(2));
    }

    @Test
    void getFirst() {
        assertEquals("hello", fll.getFirst());
    }

    @Test
    void getLast() {
        assertEquals("world", fll.getLast());
    }

    @Test
    void size() {
        assertEquals(2,fll.size());
    }
}