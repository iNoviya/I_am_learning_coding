#ifndef CIRCUITLINK_H
#define CIRCUITLINK_H

#include "Node.h"

using namespace std;
template <typename T>

class CircuitLink
{
private:
   /* data */
public:
   Node<T> *head;

   CircuitLink()
   {
      head = nullptr;
   }
   ~CircuitLink()
   {
      if (head == nullptr)
         return;
      Node<T> *current = head->next;
      Node<T> *temp = nullptr;

      while (current != head)
      {
         temp = current;
         current = current->next;
         delete temp;
      }

      delete current;
      head = nullptr;
   }

   void insert(T value)
   {
      Node<T> *added = new Node<T>(value);

      if (head == nullptr)
      {
         head = added;
         head->next = head;
         cout << value << " : added circular link list " << endl;

         return;
      }
      else
      {
         Node<T> *current = head;
         while (current->next != head)
         {
            current = current->next;
         }

         current->next = added;
         added->next = head;
      }
      cout << value << " : added circular link list " << endl;
   }

   void deleted(T value)
   {
      if (!head)
      {
         cerr << "link list is empty" << endl;
         return;
      }
      if (head->data == value)
      {
         if (head->next == head)
         {
            head = nullptr;
         }
         else
         {
            Node<T> *temp = head;
            head = head->next;
            delete temp;
         }
         cout << value << " : deleted from circular link list " << endl;
         return;
      }

      Node<T> *curent = head->next;
      while (curent->next->next != head)
      {
         if (curent->next->data == value)
         {
            Node<T> *temp = curent->next;
            curent->next = temp->next;
            delete temp;
            cout << value << " : deleted from circular link list " << endl;
            return;
         }
      }
      if (curent->next->data == value)
      {
         Node<T> *temp = curent->next;
         curent->next = head;
         delete temp;
         cout << value << " : deleted from circular link list " << endl;

         return;
      }

      cerr << value << " : did not found in circular link list " << endl;
   }
   void printed()
   {
      if (head == nullptr)
      {
         cerr << " circular link list is empty " << endl;
         return;
      }

      Node<T> *current = head;
      cout << "Circular list items :  ";
      while (current->next != head)
      {
         cout << current->data << " -> ";
         current = current->next;
      }
      cout << current->data << endl;
   }
};

#endif
