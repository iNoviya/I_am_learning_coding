
#include <iostream>
using namespace std;
bool bb8(int* a, int x) {
    a[x] = a[x] - 1;
    return a[x] >= 0;
}


bool r2d2(int a[]) {
    bool b = 1;
    for (int i = 0; i < 4; i++) {
        b = b and bb8(a, i);
    }
    return b;
}

void printArray(int a[]) {
    for (int i = 0; i < 4; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

int main()
{
    int a[] = { 1,2,3,4 };
    cout << "First r2d2 call result: " << r2d2(a) << endl;
    printArray(a);
    cout << "Second r2d2 call result: " << r2d2(a) << endl;
    printArray(a);
}