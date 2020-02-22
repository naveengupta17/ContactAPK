package adt;

public interface LinkedListADT<E> {
    void add(E item);

    E remove(E item);

    int search(E item);

    void sort();

    void print();
}

