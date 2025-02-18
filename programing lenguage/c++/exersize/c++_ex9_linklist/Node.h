#ifndef NODE_H
#define NODE_H

template <typename T>
class Node
{
private:
    T data;
    Node<T>* next;

public:
    // Constructor with parameter
    Node(T value) : data(value), next(nullptr) {}

    ~Node() {}

    Node<T>* getNext() // Pointer döndürmeli
    {
        return this->next;
    }

    T getData()
    {
        return this->data;
    }

    void setNext(Node<T>* newNext) // Pointer kullanımı doğru olmalı
    {
        this->next = newNext;
    }
};

#endif
