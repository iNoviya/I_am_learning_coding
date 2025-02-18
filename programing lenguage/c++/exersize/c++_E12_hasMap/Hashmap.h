#ifndef HASHMAP_H
#define HASHMAP_H

#include <vector>
#include <iostream>
#include <string>

using namespace std;

struct hashStruct
{
  int id;
  string name;
  int age;
};

class HashMap
{
private:
  int capasity;
  int size;

public:
  vector<hashStruct> table;

  HashMap(int cap) : capasity(cap), table(cap) , size(0) {}

  ~HashMap()
  {
    table.clear();
  }

  void calculateIndex(hashStruct hs)
  {
    return hs.id % capasity;
  }

  void insert(hashStruct hs)
  {
    if (size >= capasity)
    {
      cerr << "table is full " << endl;
      return;
    }

    int index = calculateIndex(hs);

    while (table[index].id)
    {
      index = (index + 1) % capasity;
      if (capasity <= size)
      {
        return;
      }
    }
    table[index] = hs;
  }

  hashStruct find(int id)
  {
    int index = id / capasity;
    int count = 0;
    while (1 < 2)
    {
      if (table[index].id == id)
      {
        return table[index];
      }
      else
        index++;

      count++;

      if (capasity <= count)
      {
        cerr << "dont fount " << endl;
        return ;
      }
    }
  }
};

#endif