#include "LinkList.h"
#include <iostream>

using namespace std;

int main()
{

   cout << "test empty link list  " << endl;

   LinkList<int> ll;
   cout << "link list size is  : " << ll.getSize() << endl;
   ll.push_back(4);
   ll.printList();

   ll.push_front(0);
   ll.printList();
   ll.insert(1, 1);
   ll.printList();
   cout << "link list size is  : " << ll.getSize() << endl;

   ll.push_back(15);
   ll.printList();
   ll.insert(3, 19);
   ll.printList();
   cout << "link list size is  : " << ll.getSize() << endl;

   ll.deleteNode(4);
   ll.printList();
   ll.deleteNode(23);
   ll.printList();

   cout << "link list size is  : " << ll.getSize() << endl;
}