#include <iostream>
#include <string>

using namespace std;
int main() {
    string ascii_letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    string key = "XZaVTphKNEDoCFcfJgHbenwykARWlxLBIsSMvzmGrjQdYPOuiUtq";

    string message{};

    cout << "Enter secret message: " << endl;
    getline(cin, message);
    cout << endl;

    cout << "Wprowadzono: " << message << endl;
    cout << endl;
    string encrypted_message{ message };

    size_t position{};

    for (size_t i = 0; i < message.length(); i++)
    {
        if (ascii_letters.find(encrypted_message.at(i)) != string::npos)
        {
            position = ascii_letters.find(encrypted_message.at(i));
            encrypted_message.at(i) = key.at(position);
        }
    }

    cout << "Zakodowano: " << encrypted_message << endl;
    cout << endl;

    string decrypted_message{ encrypted_message };

    for (size_t i = 0; i < decrypted_message.length(); i++)
    {
        if (key.find(decrypted_message.at(i)) != string::npos)
        {
            position = key.find(decrypted_message.at(i));
            decrypted_message.at(i) = ascii_letters.at(position);
        }
    }

    cout << "Odkodowano: " << decrypted_message << endl;

    return 0;


}