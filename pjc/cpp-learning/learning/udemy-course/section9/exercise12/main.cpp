#include <iostream>
using namespace std;

void can_you_drive(int age, bool has_car)
{
    //----WRITE YOUR CODE BELOW THIS LINE----
    if (age >= 16 && has_car)
    {
        cout << "Yes - you can drive!";
    }
    else if (age >= 16 && !has_car)
    {
        cout << "Sorry, you need to buy a car before you can drive!";
    }
    else
    {
        cout << "Sorry, come back in " << (16 - age) << " years and be sure you own a car when you come back.";
    }

    //----WRITE YOUR CODE ABOVE THIS LINE----
}