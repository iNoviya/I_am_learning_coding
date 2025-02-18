#include <iostream>
#include "binaryTree.h"
#include <vector>

int main()
{

     binaryTree bTree;

     vector<int> vec = {1, 2, 3, 4, 5, 6};

     bTree.setRoot( new Node(0));
     for (int e : vec)
     {
          bTree.insert(bTree.getRoot(), e);
     }

     cout << "post order" <<endl;
     bTree.postorderTraversal(bTree.getRoot());

     cout <<endl << "in order" <<endl;     
     bTree.inorderTraversal(bTree.getRoot());
     
     cout << endl << "pre order" <<endl;
     bTree.preorderTraversal(bTree.getRoot());

     cout << endl << bTree.getRoot()->data<<endl;
     // cout << endl << bTree.getRoot()->left->data<<endl;
     // cout << endl << bTree.getRoot()->right->data<<endl;
     cout << endl << bTree.getRoot()->left->left->data<<endl;
     // cout << endl << bTree.getRoot()->left->right->dataß<<endl;


}