
#include <iostream>
using namespace std;
int main()
{

    std::cout << "arrays exersice"<<endl;

    int numbers[][4] = { {3,5,6,9},
        {3},
        {5},
        {2},
        {8} 
    };

    int (*ptr)[4] = numbers;
    cout << **numbers+1<<endl;
}
