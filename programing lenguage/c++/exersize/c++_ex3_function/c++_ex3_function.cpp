#include <iostream>
#include <string>
using namespace std;

template <typename T>
void Print(T text) {
    cout << text<<endl;
}

int Factorial(int number){
    int result = 1;

    if (number < 0) {
        result = -1;
    }
    else if (number < 2) {
        result = 1;
    }
    else {
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
    }

    return result;
}

int main()
{
    std::cout << "__cplusplus: " << __cplusplus << std::endl;
    Print("hiii \n");
    int num;
    cout << "enter a number : "<<endl;
    cin >>  num ;
    int fact = Factorial(num);

    if (fact != -1)
    {
        cout << num << "!  = " << fact << endl;
    }
    else {
        cout << num << "!  is not defined "<<endl;
    }

    return 0;
}
