package com.alevel.nix.java.hometask.lesson16;

import java.util.AbstractList;
import java.util.Objects;

public class ForwardLinkedList<E> extends AbstractList<E> {

    private int size = 0;
    private transient Node<E> first;
    private transient Node<E> last;

    private void isLegalIndex(int index) {
        if(index < 0 || index > size()) throw new IllegalArgumentException();
    }

    private Node<E> getPrevNode(int index) {
        Node<E> temp = first;

        for (int i = 1; i < index - 1; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean addLast(E e) {
        Objects.nonNull(e);

        Node<E> item = new Node<>(e,null);

        if (last == null){
            first = item;
            last = first;
        } else {
            last.next = item;
            last = last.next;
        }

        size++;

        return true;
    }

    public boolean addFirst(E e){
        Objects.nonNull(e);

        Node<E> item = new Node<E>(e, first);

        if (last == null){
            first = item;
            last = first;
        } else {
            first = item;
        }
        size++;

        return true;
    }



    @Override
    public void add(int index, E element) {
        Objects.nonNull(element);
        isLegalIndex(index);

        if (index == 0){
            addFirst(element);
        } else if (index == size){
            addLast(element);
        } else {
            Node<E> temp = getPrevNode(index);

            temp.next = new Node<>(element, temp.next);

            size++;
        }


    }

    public void newRemove(int index){
        isLegalIndex(index);

        if (index == 0){
            removeFirst();
        } else if (index == size - 1){
            removeLast();
        } else {
            Node<E> prevNode = getPrevNode(index);
            Node<E> itemNode = prevNode.next;

            prevNode.next = itemNode.next;

            size--;
        }
    }

    public void removeFirst(){
        first = first.next;
        size--;
    }

    public void removeLast(){
        Node<E> prevNode = getPrevNode(size - 1);
        last = prevNode;
        last.next = null;
        size--;
    }

    @Override
    public E get(int index) {
        isLegalIndex(index);
        if (index == 0){
            return getFirst();
        } else if (index == size - 1){
            return getLast();
        }else {
            return getPrevNode(index+1).item;
        }
    }

    public E getFirst(){
        return first.item;
    }

    public E getLast(){
        return last.item;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<E> {
        E item;
        ForwardLinkedList.Node<E> next;

        Node(E element, ForwardLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
