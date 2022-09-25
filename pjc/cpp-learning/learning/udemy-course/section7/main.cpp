#include <vector>

std::vector<int> use_vector()
{
    std::vector<int> vec {10, 20, 30, 40, 50};

    vec.at(0) = 100;
    vec.at(vec.size() - 1) = 1000;

    return vec;
}