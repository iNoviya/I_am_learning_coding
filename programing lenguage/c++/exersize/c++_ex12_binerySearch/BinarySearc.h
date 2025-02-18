#ifndef BINARYSEARC_H
#define BINARYSEARC_H

#include "Node.h"
#include <iostream>

using namespace std;

class BinarySearc
{
private:
  /* data */
public:
  Node *root;

  BinarySearc()
  {
    root = nullptr;
  }
  ~BinarySearc()
  {
    clear(root);
    root = nullptr;
  }

  void clear(Node *temp)
  {
    if (!temp)
      return;
    clear(temp->left);
    clear(temp->right);
    delete temp;
  }

  Node *insert(Node *root, int value)
  {
    if (!root)
    {
      return new Node(value);
    }

    if (value < root->data)
    {
      root->left = insert(root->left, value);
    }
    else
    {
      root->right = insert(root->right, value);
    }
    return root;
  }

  void insert(int value)
  {
    root = insert(root, value);
  }

  void find(int value)
  {

    Node *current = root;
    if (!root)
    {
      cerr << "binary search tree is empty" << endl;
      return;
    }
    if (current->data == value)
    {
      cerr << value << " : found the item in binary tree" << endl;
      return;
    }

    while (current)
    {
      if (value < current->data)
      {
        current = current->left;
      }
      else
      {
        current = current->right;
      }
      if (current->data == value)
      {
        cerr << value << " : found the item in binary tree" << endl;
        return;
      }
    }
    cerr << value << " : did not found " << endl;
    return;
  }

  Node *deleteNode(Node *root, int value)
  {
    if (root == nullptr)
    {
      return root; // Ağaç boşsa veya düğüm bulunamazsa
    }

    // Aranacak düğümü bul
    if (value < root->data)
    {
      root->left = deleteNode(root->left, value);
    }
    else if (value > root->data)
    {
      root->right = deleteNode(root->right, value);
    }
    else
    {
      // Silinecek düğüm bulundu

      // Durum 1: Düğümün çocuğu yok (yaprak düğüm)
      if (root->left == nullptr && root->right == nullptr)
      {
        delete root;
        return nullptr;
      }

      // Durum 2: Düğümün bir çocuğu var
      if (root->left == nullptr)
      {
        Node *temp = root->right;
        delete root;
        return temp;
      }
      else if (root->right == nullptr)
      {
        Node *temp = root->left;
        delete root;
        return temp;
      }

      // Durum 3: Düğümün iki çocuğu var
      Node *temp = findMin(root->right);                 // Sağ alt ağacın en küçük düğümünü bul
      root->data = temp->data;                           // Düğümün değerini güncelle
      root->right = deleteNode(root->right, temp->data); // En küçük düğümü sil
    }

    return root;
  }

  Node *findMin(Node *node)
  {
    while (node && node->left != nullptr)
    {
      node = node->left;
    }
    return node;
  }

  void preorderTraversal(Node *tempRoot)
  {
    if (!tempRoot)
    {
      return;
    }
    cout << tempRoot->data << " -> ";
    preorderTraversal(tempRoot->left);
    preorderTraversal(tempRoot->right);
  }

  void inorderTraversal(Node *tempRoot)
  {
    if (!tempRoot)
    {
      return;
    }
    inorderTraversal(tempRoot->left);
    cout << tempRoot->data << " -> ";
    inorderTraversal(tempRoot->right);
  }

  void postorderTraversal(Node *tempRoot)
  {
    if (!tempRoot)
    {
      return;
    }
    postorderTraversal(tempRoot->left);
    postorderTraversal(tempRoot->right);
    cout << tempRoot->data << " -> ";
  }
};

#endif