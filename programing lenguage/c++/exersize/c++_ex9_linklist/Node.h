#ifndef NODE_H
#define NODE_H

#include <iostream>
using namespace std;

template <typename T>
class Node {
public:
    T data;       // Veri kısmı
    Node<T>* next;  // Sonraki düğüme işaretçi (Node türünde)

    // Kurucu metot
    Node(T value) {
        data = value;
        next = nullptr;
    }

    // Destructor
    ~Node() {
        
    }
};

#endif
