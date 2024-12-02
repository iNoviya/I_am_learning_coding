#ifndef LINKLIST_H
#define LINKLIST_H

#include <iostream>
#include "Node.h"
using namespace std;

template <typename T>

class LinkList
{
private:
   Node<T> *head;

public:
   LinkList()
   {
      head = nullptr;
   }
   ~LinkList()
   {
      Node<T> *current = head;
      while (current != nullptr)
      {
         Node<T> *next = current->next;
         delete current;
         current = next;
      }
   }
   void append(T x)
   {
      Node<T> *nextNode = new Node(x);
      if (head == nullptr)
      {
         head = nextNode;
      }
      else
      {
         Node<T> *current = head;
         while (current->next != nullptr)
         {
            current = current->next;
         }
         current->next = nextNode;
      }
      cout<< x <<" is inseted in linkList " <<endl; 
   }

   void deleteNode(T value) {
    if (head == nullptr) {
        cout << "Liste boş, silinecek eleman yok." << endl;
        return;
    }

    if (head->data == value) {
        Node<T>* temp = head;
        head = head->next;
        delete temp;
        cout << value << " silindi." << endl;
        return;
    }

    Node<T>* current = head;
    while (current->next != nullptr && current->next->data != value) {
        current = current->next;  
    }

    if (current->next != nullptr && current->next->data == value) {
        Node<T>* temp = current->next;
        current->next = current->next->next;
        delete temp;
        cout << value << " is deleted." << endl;
    } else {
        cout << value << " did not found in list." << endl;
    }
}


   void printList()
   {
      if (head == nullptr)
      {
         cout << " linklist is empty " << endl;
      }
      else
      {
         Node<T> *current = head;
         while (current != nullptr)
         {
            cout << current->data << " -> ";
            current = current->next;
         }
         cout << " NULL " << endl;
      }
   }
};

#endif