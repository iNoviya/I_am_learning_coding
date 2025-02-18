#ifndef NODE_H
#define NODE_H

class Node
{
private:
  /* data */
public:
  Node* left;
  Node* right;
  int data;


  Node(int value){
    left = nullptr;
    right = nullptr;
    data = value;
  }
  ~Node(){
    left = nullptr;
    right = nullptr;
  }
};


#endif