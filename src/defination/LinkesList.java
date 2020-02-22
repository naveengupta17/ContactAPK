package defination;

import adt.LinkedListADT;
import type.Person;

import java.util.ArrayList;
import java.util.NoSuchElementException;

 public class LinkesList<E> implements LinkedListADT<E> {

    private Node<E> head = null;
    private int size = 0;


     private Node<E> getNode(int index) {
        Node<E> response = null;
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        else{
            Node<E> temp = head;
            for (int i = 0; i < index && temp !=null; i++) {
                temp = temp.getNext();

            }
            response = temp;
        }

        return response;
    }

    public E get(int index) {
        E response = null;
        return response;
    }

    public E set(int index, E newValue) {
        E response = null;
        return response;
    }

    private void addFirst(E item) {
        head = new Node<>(item,head);
        size++;

    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item,node.getNext());
        size++;

    }

    public void add(int index, E item) {
        if ( index <0 || index > size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            addFirst(item);
        }else{
            addAfter(getNode(index-1) ,item);
        }

    }

    @Override
    public void add(E item) {
        add(size,item);

    }

    private E removeFirst(E item){
        if(head == null){
            throw new NoSuchElementException("Khali h be");

        }
        head = head.next;
        /*E response = head.data;*/
        size --;
        return item;

    }
    private E removeAfter(E item){
        int index = search(item);
        Node<E> newNode = getNode(index-1);
        Node<E> nextNode = getNode(index);
        newNode.next = nextNode.next;
        size --;
        return item;
    }
    public void removeByIndex(int index){
         if(index == 0){
             removeFirst(getNode(index).data);
         }
         else {
             removeAfter(getNode(index).data);
         }
    }






    @Override
    public E remove(E item) {
        int index = search(item);
        if( index == 0){
            removeFirst(item);
        }
        else{
            removeAfter(item);
        }
        return item;
    }
    public int getSize(){
        return size;
    }
    public ArrayList<E> searchForContact1(){
        ArrayList<E> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++){
            arrayList.add(getNode(i).data);
        }
        return arrayList;

    }
    @Override
    public int search(E item) {
        int res = 0;
        for (int i = 0; i < size; i++) {
            if (getNode(i).data == item) {
                res = i;
                break;

            }
        }
        return res;
    }

    @Override
    public void sort() {


    }

    @Override
    public void print() {
        System.out.println("---Here are all your Contacts---");
        for (int i = 0; i < size; i++) {
            E data = this.getNode(i).getData();
            System.out.print( data );

        }

    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        private Node(E data) {
            this.data = data;
        }

        private E getData() {
            return data;
        }

        private Node<E> getNext() {
            return next;
        }
    }
}


