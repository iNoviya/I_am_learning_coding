#include <iostream>
#include <vector>
#include "Queue.h"

using namespace std;

int main()
{
   cout << "test queue " << endl;
   Queue queue;

   cout << "add 1" << endl;
   queue.enqueue(1);
   queue.print();

   cout << "add 3" << endl;
   queue.enqueue(3);
   queue.print();

   cout<<"add 231"<<endl;
   queue.enqueue(231);
   queue.print();
   cout<<"add 91"<<endl;
   queue.enqueue(91);
   queue.print();
   cout<<"add 57"<<endl;
   queue.enqueue(57);
   queue.print();
   cout<<"add 32"<<endl;
   queue.enqueue(32);
   queue.print();
   cout<<"add 13"<<endl;
   queue.enqueue(13);
   queue.print();

   cout << queue.dequeue() << " is deleted im queue"<<endl; 
   cout << queue.dequeue() << " is deleted im queue"<<endl; 
   cout << queue.dequeue() << " is deleted im queue"<<endl; 
   cout << queue.dequeue() << " is deleted im queue"<<endl; 
   cout << queue.dequeue() << " is deleted im queue"<<endl; 
   
}