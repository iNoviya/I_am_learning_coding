#include "Stack.h"
#include <iostream>
#include <vector>

Stack::Stack()
{
	this->top = -1;
	stackList.reserve((maxSize));
}

void Stack::push(int x)
{
	if (top >= maxSize -1)
	{
		cerr << " ERROR : stack overloding max size " << endl;
	}
	else
	{
		top += 1;
		stackList[top] = x;
	}
}

int Stack::pop()
{
	if (top < 0)
	{
		cerr << "ERROR :  no item in stack " << endl;
		return -1;
	}
	else
	{
		int popValue = stackList[top]; 
		// stackList[top] = nullptr;
		top -= 1;
		return popValue;
	}
}

int Stack::peek()
{
	if (top < 0 || top >= maxSize)
	{
		cerr << "ERROR : no item in stack " << endl;
		return -1;
	}
	else
	{
		return stackList[top];
	}
}
int Stack::size()
{
	if (top < 0)
	{
		return 0;
	}
	else
	{
		return top;
	}
}

bool Stack::empty()
{
	if (top < 0)
		return true;

	return false;
}
void Stack::print()
{
	cout << "top :" << top << endl;
	cout << "size : "<< size()<< endl;
	for (int i = 0; i <= maxSize; ++i) {
            cout << stackList[i] << " ";
        }
	cout << endl;
}