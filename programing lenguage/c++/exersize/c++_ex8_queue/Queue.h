#ifndef QUEUE_H
#define QUEUE_H
#include <vector>

#define MAX_SIZE 4 // total size will be 5 

using namespace std;

class Queue
{
private:
   /* data */


public:
   int front;
   int rear;
   vector<int> eq;
   int sizeQueue;

   Queue();
   void enqueue(int x);
   int dequeue();
   int index(int x);

   void print();

   int getSizeEq();

   ~Queue();
};


#endif