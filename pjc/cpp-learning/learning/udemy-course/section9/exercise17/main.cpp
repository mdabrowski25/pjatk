#include <vector>
using namespace std;

int calculate_pairs(vector<int> vec)
{
    //----WRITE YOUR CODE BELOW THIS LINE----
    int result{0};

    for (size_t i = 0; i < vec.size(); i++)
    {
        for (size_t j = 0; j < vec.size(); j++)
        {
            if (i == j)
            {
                continue;
            }
            result += (vec.at(i) * vec.at(j));
        }
    }

    //----WRITE YOUR CODE ABOVE THIS LINE----
    //----DO NOT MODIFY THE CODE BELOW THIS LINE----
    return result;
}