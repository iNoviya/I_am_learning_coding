#include <iostream>
#include "CircuitLink.h"

using namespace std;

int main()
{

   CircuitLink<int> clist;

   clist.deleted(10);
   clist.printed();
   clist.insert(10);
   clist.printed();
   clist.deleted(10);
   clist.printed();
   clist.insert(20);
   clist.printed();
   clist.insert(30);
   clist.printed();
   clist.insert(40);
   clist.printed();
   clist.insert(50);
   clist.printed();
   clist.deleted(40);
   clist.printed();
   clist.deleted(50);
   clist.printed();
}