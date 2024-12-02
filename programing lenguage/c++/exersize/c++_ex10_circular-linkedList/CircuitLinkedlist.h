#ifndef CIRCUITLINKEDLIST_H
#define CIRCUITLINKEDLIST_H

#include "Node.h"

using namespace std;

template <typename T>

class CircuitLinkedlist
{
private:
   Node<T> *tail;

public:
   CircuitLinkedlist()
   {
      tail = nullptr;
   }
   ~CircuitLinkedlist()
   {
   }

   void insert(T value)
   {
      Node<T> *newNode = new Node<T>(value);
      if (tail == nullptr)
      {
         tail = newNode;
         tail->next = tail;
      }
      else
      {
         newNode->next = tail->next;
         tail->next = newNode;
         tail = newNode;
      }
      cout << value << " is inserted into the circular linked list" << endl;
   }
   void deleteNode(T value)
   {
      Node<T> *target = new Node(value);

      if (tail == nullptr)
      {
         cout << "list is empty so, you cant delete " << value << " node" << endl;
      }
      if (tail->data == target->data)
      {
         tail->next = nullptr;
         tail = nullptr;
      }

      Node<T> *current = tail->next;

      while (current->next->data != target->data && current->next != nullptr)
      {
         current = current->next;
      }

      if (current->next->data != target->data && current->next == nullptr)
      {
         Node<T> *temp = current->next;
         current->next = current->next->next;
         delete temp;
         cout << value << " is deleted." << endl;
      }
      else
      {
         cout << value << " is did not fount deleted." << endl;
      }
   }
   void print()
   {
      if (tail == nullptr)
      {
         cout << "list is empty " << endl;
      }

      Node<T> *current = tail->next;
      do
      {
         cout << current->data << " -> ";
         current = current->next;
      } while (current != tail->next);
      cout << "NULL" << endl;
   }
};

#endif
