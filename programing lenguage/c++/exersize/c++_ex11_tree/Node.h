#ifndef NODE_H
#define NODE_H

class Node
{

public:
   Node *left;
   Node *right;
   int data;


   Node(int value ){
      left = nullptr;
      right = nullptr;
      data = value;
   }
   ~Node(){
      
   }
};



#endif