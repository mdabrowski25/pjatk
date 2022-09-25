#include <iostream>
#include <vector>

using namespace std;

void program_loop();
void print_choices();
void print_vector(const vector<int>& vec);
int get_user_number();
double count_avg(const vector<int>& vec);
int get_smallest_el(const vector<int>& vec);
int get_largest_el(const vector<int>& vec);
void exit(string mess, bool& flag);

int main()
{
    program_loop();
}

void program_loop() {
    {
        bool program_running = true;
        char choice{};
        vector<int> list = { 2, 4, 70 };

        do
        {
            cout << endl;
            print_choices();
            cin >> choice;
            cout << endl;

            switch (choice)
            {
                case 'p':
                case 'P':
                {
                    print_vector(list);
                    break;
                }
                case 'a':
                case 'A':
                {
                    int number = get_user_number();
                    list.push_back(number);
                    cout << "Dodano: " << number << endl;
                    break;
                }
                case 'm':
                case 'M': {
                    cout << "Srednia: " << count_avg(list) << endl;
                    break;
                }
                case 's':
                case 'S': {
                    cout << "Najmniejszy element: " << get_smallest_el(list) << endl;
                    break;
                }
                case 'l':
                case 'L': {

                    cout << "Najwiekszy element: " << get_largest_el(list) << endl;
                    break;
                }
                case 'q':
                case 'Q': {
                    exit("Goodbye", program_running);
                    break;
                }
                default:
                {
                    break;
                }
            }
        } while (program_running);
    }
}

void print_choices() {
    cout << "P - Print numbers" << endl;
    cout << "A - Add a number" << endl;
    cout << "M - Display mean of the numbers" << endl;
    cout << "S - Display the smallest number" << endl;
    cout << "L - Print Display the largest number" << endl;
    cout << "Q - Quit" << endl;
    cout << "Podaj opcje: ";
};

void print_vector(const vector<int>& vec) {
    cout << "[ ";
    for (size_t i = 0; i < vec.size(); i++)
    {
        cout << vec.at(i) << " ";
    }
    cout << "]";
    cout << endl;
}

int get_user_number() {
    int number{};
    cout << "Podaj liczbe: ";
    cin >> number;
    cout << endl;
    return number;
}

double count_avg(const vector<int>& vec) {
    int sum{ 0 };
    for (auto el : vec)
    {
        sum += el;
    }
    return (sum / (static_cast<double>(vec.size())));
}

int get_smallest_el(const vector<int>& vec) {
    int smallest{ vec.at(0) };
    for (auto el : vec)
    {
        if (el < smallest)
        {
            smallest = el;
        }
    }
    return smallest;
}

int get_largest_el(const vector<int>& vec) {
    int largest{ vec.at(0) };
    for (auto el : vec)
    {
        if (el > largest)
        {
            largest = el;
        }
    }
    return largest;
}

void exit(string message, bool& flag) {
    cout << message << endl;
    flag = false;
}