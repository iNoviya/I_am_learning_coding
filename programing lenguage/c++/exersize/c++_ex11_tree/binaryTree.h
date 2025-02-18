#ifndef BINARYTREE_H
#define BINARYTREE_H

#include "Node.h"
#include <iostream>

using namespace std;

class binaryTree
{
public:
   Node *root;

   binaryTree()
   {
      root = NULL;
   }
   ~binaryTree()
   {
      clearTree(root);
      root = nullptr;
   }
   void clearTree(Node *temp)
   {
      if (!temp)
      {
         return;
      }
      clearTree(temp->left);
      clearTree(temp->right);
      delete temp;
   }

   Node *insert(Node *root, int value)
   {
      if (root == nullptr)
      {
         return new Node(value);
      }
      if (root->left == root->right)
      {
         root->left = insert(root->left, value);
      }
      else
      {
         if (!root->left)
         {
            root->left = insert(root->left, value);
         }
         else if (!root->right)
         {
            root->right = insert(root->right, value);
         }
         else
         {

         }
      }
      return root;
   }

   void inorderTraversal(Node *root)
   {
      if (!root)
      {
         return;
      }
      inorderTraversal(root->left);
      cout << root->data << " -> ";
      inorderTraversal(root->right);
   }
   void preorderTraversal(Node *root)
   {
      if (!root)
      {
         return;
      }
      cout << root->data << " -> ";
      preorderTraversal(root->left);
      preorderTraversal(root->right);
   }

   void postorderTraversal(Node *root)
   {
      if (!root)
      {
         return;
      }
      postorderTraversal(root->left);
      postorderTraversal(root->right);
      cout << root->data << " -> ";
   }

   Node *getRoot()
   {
      return root;
   }
   void setRoot(Node *newRoot)
   {
      this->root = newRoot;
   }
};

#endif