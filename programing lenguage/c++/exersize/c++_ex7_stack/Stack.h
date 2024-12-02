#ifndef STACK_H
#define STACK_H

#include <vector>
#define maxSize 4

using namespace std;

class Stack
{
public:
	int top;
	vector<int> stackList;

	Stack();

	void push(int x);
	int peek();
	int pop();
	int size();
	bool empty();

	void print();
};

#endif