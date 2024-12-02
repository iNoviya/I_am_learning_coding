#ifndef NODE_H
#define NODE_H

#include <iostream>
template <typename T>

class Node
{
public:
   Node<T> *next;
   T data;

   Node(T value)
   {
      next = nullptr;
      data = value;
   }
   ~Node();
};


#endif