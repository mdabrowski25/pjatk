#include <iostream>

int main()
{
    int cents{};
    std::cout << "Enter number of cents: ";
    std::cin >> cents;
    std::cout << std::endl;

    int change[]{0, 0, 0, 0, 0};
    int values_in_cents[]{100, 25, 10, 5, 1};

    for (int i = 0; i < 5; i++)
    {
        change[i] = cents / values_in_cents[i];
        if (change[i] > 0)
        {
            cents -= (values_in_cents[i] * change[i]);
        }
    }

    std::cout << "dollars: " << change[0] << std::endl;
    std::cout << "quaters: " << change[1] << std::endl;
    std::cout << "dimes: " << change[2] << std::endl;
    std::cout << "nickels: " << change[3] << std::endl;
    std::cout << "pennies: " << change[4] << std::endl;
}