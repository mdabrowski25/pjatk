#include <iostream>
using namespace std;

void logical_operators(int age, bool parental_consent, bool ssn, bool accidents)
{

    //----WRITE YOUR CODE BELOW THIS LINE----

    bool check = (age >= 18 || (age > 15 && parental_consent)) && ssn && !accidents;
    if (check) //WRITE ALL YOUR CODE WITHIN THE PARENTHESES
        cout
            << "Yes, you can work.";

    //----WRITE YOUR CODE ABOVE THIS LINE----
    return;
}