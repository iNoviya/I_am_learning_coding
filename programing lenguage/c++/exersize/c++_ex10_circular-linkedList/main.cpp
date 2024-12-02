#include <iostream>
#include "CircuitLinkedlist.h"

using namespace std;

int main()
{

   CircuitLinkedlist<int> cLinkedlist;

   cLinkedlist.deleteNode(10);
   cLinkedlist.print();
   cLinkedlist.insert(10);
   cLinkedlist.print();
   cLinkedlist.deleteNode(10);
   cLinkedlist.print();
   cLinkedlist.insert(20);
   cLinkedlist.print();
   cLinkedlist.insert(30);
   cLinkedlist.print();
   cLinkedlist.insert(40);
   cLinkedlist.print();
   cLinkedlist.insert(50);
   cLinkedlist.print();
   cLinkedlist.deleteNode(40);
   cLinkedlist.print();
   cLinkedlist.deleteNode(50);
   cLinkedlist.print();
}