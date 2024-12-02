#include <iostream>
#include <vector>
#include "Queue.h"

using namespace std;

Queue::Queue()
{
   sizeQueue = 0;
   front = 0;
   rear = 0;
   eq.reserve((MAX_SIZE));
}

void Queue::enqueue(int x)
{
   if ((rear + 1) % (MAX_SIZE + 1) == front)
   {
      cout << x << " is did not add because queue is full " << endl;
   }
   else
   {
      if (getSizeEq() == 0)
      {
         front = 0;
      }
      rear = (rear + 1) % (MAX_SIZE + 1);
      sizeQueue++;
      eq[rear] = x;
   }
}
int Queue::dequeue()
{
   if (getSizeEq() == 0)
   {
      cout << "no item in queue" << endl;
      return -1;
   }
   else
   {
      int frontValue = eq[front];
      if (rear == front + 1)
      {
         rear = front = -1;
      }
      else
      {
         front = (front + 1) % (MAX_SIZE + 1)
      }
      return frontValue;
   }
}

int Queue::index(int x)
{
   if (x >= front && x <= rear)
   {
      return eq[x];
   }
   else
      throw runtime_error(" index is not within certain limits  ");
}
void Queue::print()
{
   for (int i = front; i < rear; i++)
   {
      cout << eq[i] << " ";
   }
   cout << endl;
}
int Queue::getSizeEq()
{
   return sizeQueue;
}

Queue::~Queue()
{
   eq.clear();
}