#include "BinarySearc.h"
#include <iostream>
#include <vector>

int main()
{
  BinarySearc bs;

  bs.insert(5);
  bs.insert(3);
  bs.insert(10);
  vector <int> vec = {1,2,4,45,42,0,-4,-3};

  for (int e : vec){
    bs.insert(e);
  }

  bs.find(4);

  cout<<endl;
  bs.preorderTraversal(bs.root);
  
  cout<<endl;
  bs.inorderTraversal(bs.root);

  cout<<endl;
  bs.postorderTraversal(bs.root);

  cout<<endl;

  bs.deleteNode(bs.root,-3);
  bs.inorderTraversal(bs.root);
  cout<<endl;
  bs.deleteNode(bs.root,10);
  bs.inorderTraversal(bs.root);

}
