#include <vector>
#include <iostream>

using namespace std;

class Node
{
public:
   int data;
   Node *next;
   Node(int value);
   ~Node();
};

Node::Node(int value)
{
   data = value;
   next = nullptr;
}

Node::~Node()
{
}
