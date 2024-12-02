
#include <iostream>

using namespace std;

int main()
{
    

    int a = 5;
    int* aptr = &a;
    int &aRef = a;

    cout << a << endl;
    cout<< aptr<<endl;
    cout << aRef << endl;


    int b[3] = { 0,1,2 };
    int* bptr = &b[0];
    int &bRef = b[0];
    cout << bptr << endl;
    cout << bptr + 1 << endl;
    cout <<" prss b " << b << endl;
    cout << " prss b + 1 :" << b +1 << endl;
    cout << " prss *b  ptr :" << *b  << endl;
    cout << " prss *b + 1 ptr :" << *b + 1 << endl;
    cout << " prss *(b + 1) ptr :" << *(b+1) << endl;

    cout << " prss &b  ref :" << &b  << endl;
    cout << " prss &b + 1  ref :" << &b + 1 << endl;


    cout << bRef << endl;
    cout << bRef + 2 << endl;


    int c[2][3] = { {5,01,02},{10,11,12} };

    cout << " prss c" << c << endl;
    cout << " prss c[0] :" << *c[0] << endl;
    cout << " prss c[0] :" << *(c[0] + 1) << endl;
    cout << " prss c[0] :" << *(c[1] + 1) << endl;

    cout << " prss c + 1 :" << c+ 1 << endl;
    cout << " prss *c  ptr :" << *c << endl;
    cout << " prss *c + 1 ptr :" << *c + 1 << endl;
    cout << " prss *(c + 1) ptr :" << *(c + 1) << endl;

    cout << " prss &c  ref :" << &c << endl;
    cout << " prss &c + 1  ref :" << &c + 1 << endl;

  




    cout << endl<<endl<<endl << endl;

}


