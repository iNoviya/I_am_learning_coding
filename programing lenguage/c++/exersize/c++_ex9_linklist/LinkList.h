#include "Node.h"
#include <iostream>

using namespace std;

#ifndef LINKLIST_H
#define LINKLIST_H

template <typename T>

class LinkList
{
private:
   Node<T> *head;

public:
   LinkList() : head(nullptr) {}
   ~LinkList()
   {
      while (head)
      {
         Node<T> *temp = head;
         head = head->getNext();
         delete temp;
      }
   }

   void push_front(T value)
   {
      Node<T> *newHead = new Node<T>(value);
      newHead->setNext(head);
      this->head = newHead;
      cout << "push_front  add  list  T : " << value << endl;
   }

   void push_back(T value)
   {
      Node<T> *newNode = new Node<T>(value);

      if (!head)
      {
         head = newNode;
         return;
      }

      Node<T> *currentNode = head;
      while (currentNode->getNext() != nullptr)
      {
         currentNode = currentNode->getNext();
      }
      currentNode->setNext(newNode);

      cout << "push_back  add  list  T : " << value << endl;
   }

   void insert(int index, T value)
   {
      if (index < 0 || index > getSize())
      {
         std::cerr << "Undefined index" << std::endl;
         return;
      }

      if (index == 0)
      {
         push_front(value);
         return;
      }

      int count = 0;
      Node<T> *newNode = new Node<T>(value);
      Node<T> *currentNode = head;

      while (count < index - 1)
      {
         currentNode = currentNode->getNext();
         count++;
      }

      newNode->setNext(currentNode->getNext());
      currentNode->setNext(newNode);

      cout << "insert  add  list  T : " << value << " index : " << index << endl;
   }

   int getSize()
   {
      int caunt = 0;
      Node<T> *currentNode = head;
      while (currentNode != nullptr)
      {
         currentNode = currentNode->getNext();
         caunt++;
      }
      return caunt;
   }

   void deleteNode(T value)
   {
      if (!head)
         return;

      if (head->getData() == value)
      {
         Node<T> *temp = head;
         head = head->getNext();
         delete temp;
         return;
      }

      Node<T> *currentNode = head;
      while (currentNode->getNext() != nullptr && currentNode->getNext()->getData() != value)
      {
         currentNode = currentNode->getNext();
      }

      if (currentNode->getNext() == nullptr)
      {
         cerr << "Data not found in LinkList" << endl;
         return;
      }
      cout << "delete   T : " << value << endl;

      Node<T> *temp = currentNode->getNext();
      currentNode->setNext(temp->getNext());
      delete temp;
   }

   void printList()
   {
      cout << "Linklist items "<< endl;
      Node<T> *currentNode = head;
      while (currentNode != nullptr)
      {
         cout << currentNode->getData() << " -> ";
         currentNode = currentNode->getNext();
      }
      cout << " NULL " << endl;
   }
}

#endif