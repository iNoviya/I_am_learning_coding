#include <iostream>

int main()
{
    std::cout << "c++ ex2 math operators \n";

    int number1, number2;

    std::cin >> number1 >> number2;

    std::cout << "a + b = " << number1 + number2 << "\n";
    std::cout << "a - b = "<< number1 - number2 << "\n";
    std::cout << "a * b = "<< number1* number2 << "\n";

    if (number2 != 0) {
        std::cout << "a / b = "<< number1 / number2 << "\n";
        std::cout << "a mod b = "<< number1% number2 << "\n";
    } 
    else
    {
        std::cout << " ERROR :: b = 0 so indefened result \n";
    }


}

// Programı çalıştır: Ctrl + F5 veya Hata Ayıkla > Hata Ayıklamadan Başlat menüsü
// Programda hata ayıkla: F5 veya Hata Ayıkla > Hata Ayıklamayı Başlat menüsü

