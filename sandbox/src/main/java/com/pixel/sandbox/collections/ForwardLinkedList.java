package com.pixel.sandbox.collections;

import java.util.AbstractList;
import java.util.Objects;

public class ForwardLinkedList<E> extends AbstractList<E> {

    private int size = 0;
    private transient Node<E> first;
    private transient Node<E> last;

    private boolean isLegalIndex(int index) {
        if(index < 0 || index > size()) throw new IllegalArgumentException();
        return true;
    }

    private Node<E> getNode(int index) {
        Node<E> temp = first;

        for (int i = 1; i <= index; i++) {
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

    public boolean newAdd(int index, E element) {
        Objects.nonNull(element);
        isLegalIndex(index);

        if (index == 0){
            addFirst(element);
        } else if (index == size){
            addLast(element);
        } else {
            Node<E> temp = getNode(index);

            temp.next = new Node<>(element, temp.next);

            size++;
        }

        return true;
    }

    public boolean newRemove(int index){
        isLegalIndex(index);

        if (index == 0){
            removeFirst();
        } else if (index == size - 1){
            removeLast();
        } else {
            Node<E> prevNode = getNode(index);
            Node<E> itemNode = prevNode.next;

            prevNode.next = itemNode.next;

            size--;
        }

        return true;
    }

    public boolean removeFirst(){
        first = first.next;
        size--;
        return true;
    }

    public boolean removeLast(){
        Node<E> prevNode = getNode(size - 2);
        last = prevNode;
        last.next = null;
        size--;
        return true;
    }

    @Override
    public E get(int index) {
        isLegalIndex(index);
        if (index == 0){
            return getFirst();
        } else if (index == size - 1){
            return getLast();
        }else {
            return getNode(index+1).item;
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
