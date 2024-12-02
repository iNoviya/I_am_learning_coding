// c++_ex7_stract.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
#include <vector> 
#include <iostream>
#include "Stack.h"

using namespace std;

int main()
{
    std::cout << "Test stack " << endl;

    Stack s;
    s.empty() ? cout << "stack is empty " << endl : cout << "stack is not  empty " << endl;
    cout<< "peek test in  with  empty stacks"<< endl;
    cout<< s.peek() <<endl;

    s.push(1);
    s.print();

    s.push(5);
    s.push(3);
    int a = s.peek();
    cout << "a is a peek number  = " << a << endl;
    s.print();
    s.push(123);
    s.push(7654);
    cout << "test owerloding stack " << endl;
    s.push(97979);
    s.print();

    cout << "test pop " << endl;
    cout<< s.pop()<< "  is value deleted in stack "<< endl;
    cout<< s.pop()<< "  is value deleted in stack "<< endl;
    cout<< s.pop()<< "  is value deleted in stack "<< endl;
    

    s.print();
    s.empty() ? cout << "stack is empty " << endl : cout << "stack is not  empty " << endl;
    s.print();
}
