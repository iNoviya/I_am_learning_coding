#include "LinkList.h"
#include <iostream>

using namespace std;

int main()
{
   LinkList<int> list;

   cout << "test empty link list  " << endl;
   list.printList();

   list.append(10);
   list.printList();
   list.append(342);
   list.append(123);
   list.append(56);
   list.printList();

   list.deleteNode(10);
   list.printList();
   list.deleteNode(123);
   list.printList();
   list.deleteNode(56);
   list.printList();
}