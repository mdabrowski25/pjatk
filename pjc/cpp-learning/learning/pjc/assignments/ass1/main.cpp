#include <iostream>

int strLength(const char *str)
{
    int i = 0;
    while (str[i] != '\0')
    {
        i++;
    }
    return i;
}

bool checkpass(const char *pass)
{
    if (strLength(pass) < 8)
    {
        std::cout << "Password is too short" << std::endl;
        return false;
    }
    bool has_upper = false;
    bool has_lower = false;
    bool has_digit = false;
    bool has_special = false;

    char table[] = {};
    int counter = 0;

    for (int i = 0; i < strLength(pass); i++)
    {
        table[counter++] = pass[i];
        if (pass[i] >= 'A' && pass[i] <= 'Z')
        {
            has_upper = true;
        }
        else if (pass[i] >= 'a' && pass[i] <= 'z')
        {
            has_lower = true;
        }
        else if (pass[i] >= '0' && pass[i] <= '9')
        {
            has_digit = true;
        }
        else
        {
            has_special = true;
        }
    }

    for (int i = 0; i < strLength(pass); ++i)
    {
        if (pass[i] == pass[i + 1])
        {
            std::cout << "Password is too weak" << std::endl;
            return false;
        }
        if (pass[i] + pass[i + 1] == pass[i + 2] + pass[i + 3])
        {
            std::cout << "Password is too weak" << std::endl;
            return false;
        }
    }

    if (has_upper && has_lower && has_digit && has_special)
    {
        return true;
    }

    if (!has_upper)
    {
        std::cout << "Password must contain at least one uppercase letter" << std::endl;
    }

    if (!has_lower)
    {
        std::cout << "Password must contain at least one lowercase letter" << std::endl;
    }

    if (!has_digit)
    {
        std::cout << "Password must contain at least one digit" << std::endl;
    }

    if (!has_special)
    {
        std::cout << "Password must contain at least one special character" << std::endl;
    }

    return false;
}

int main()
{
    using std::cout;
    using std::endl;
    const char *passes[] =
        {"AbcDe93", "A1b:A1b>", "Ab:Acb<", "abc123><", "Zorro@123", nullptr};
    for (int i = 0; passes[i] != nullptr; ++i)
    {
        cout << "checking " << passes[i] << endl;
        if (checkpass(passes[i]))
            cout << "OK" << endl;
        cout << endl;
    }
}
