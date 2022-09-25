#include <iostream>
#include <vector>

using namespace std;
int main()
{
    bool program_running = true;
    char choice{};
    vector<int> list = { 2, 4, 70 };

    do
    {
        cout << endl;
        cout << "P - Print numbers" << endl;
        cout << "A - Add a number" << endl;
        cout << "M - Display mean of the numbers" << endl;
        cout << "S - Display the smallest number" << endl;
        cout << "L - Print Display the largest number" << endl;
        cout << "Q - Quit" << endl;
        cout << "Podaj opcje: ";
        cin >> choice;
        cout << endl;

        switch (choice)
        {
            case 'p':
            case 'P':
            {
                cout << "[ ";
                for (size_t i = 0; i < list.size(); i++)
                {
                    cout << list.at(i) << " ";
                }
                cout << "]";
                cout << endl;
                break;
            }
            case 'a':
            case 'A':
            {
                int number{ 0 };
                cout << "Podaj liczbe: ";
                cin >> number;
                cout << endl;
                if (number != 0)
                {
                    list.push_back(number);
                    cout << "Dodano: " << number << endl;
                }
                break;
            }
            case 'm':
            case 'M': {
                int sum{ 0 };
                for (auto el : list)
                {
                    sum += el;
                }
                double avg = (sum / (static_cast<double>(list.size())));
                cout << "Srednia: " << avg << endl;
                break;
            }
            case 's':
            case 'S': {
                int smallest{ list.at(0) };
                for (auto el : list)
                {
                    if (el < smallest)
                    {
                        smallest = el;
                    }
                }
                cout << "Najmniejszy element: " << smallest << endl;
                break;
            }
            case 'l':
            case 'L': {
                int largest{ list.at(0) };
                for (auto el : list)
                {
                    if (el > largest)
                    {
                        largest = el;
                    }
                }
                cout << "Najwiekszy element: " << largest << endl;
                break;
            }
            case 'q':
            case 'Q': {
                cout << "Goodbye" << endl;
                program_running = false;
                break;
            }
            default:
            {
                break;
            }
        }
    } while (program_running);
}