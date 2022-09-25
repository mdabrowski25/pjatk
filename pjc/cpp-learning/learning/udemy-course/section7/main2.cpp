#include <iostream>
#include <vector>

int main()
{
    std::vector<int> vec1{};
    std::vector<int> vec2{};

    vec1.push_back(10);
    vec1.push_back(20);

    int vec1_size = vec1.size();
    for (int i = 0; i < vec1_size; i++)
    {
        std::cout << vec1.at(i) << " ";
    };
    std::cout << std::endl;
    std::cout << std::endl;

    vec2.push_back(100);
    vec2.push_back(200);

    int vec2_size = vec2.size();

    for (int i = 0; i < vec2_size; i++)
    {
        std::cout << vec2.at(i) << " ";
    }
    std::cout << std::endl;
    std::cout << std::endl;

    std::vector<std::vector<int>> vector_2d{std::vector<int>{}, std::vector<int>{}};

    for (int i = 0; i < vec1_size; i++)
    {
        vector_2d.at(0).push_back(vec1.at(i));
    }

    for (int i = 0; i < vec2_size; i++)
    {
        vector_2d.at(1).push_back(vec2.at(i));
    }

    int vector2d_size = vector_2d.size();

    for (int i = 0; i < vector2d_size; i++)
    {
        for (int j = 0; j < ((int)vector_2d.at(i).size()); j++)
        {
            std::cout << vector_2d.at(i).at(j) << " ";
        }
        std::cout << std::endl;
    }
    std::cout << std::endl;
    std::cout << std::endl;

    vec1.at(0) = 1000;

    for (int i = 0; i < vector2d_size; i++)
    {
        for (int j = 0; j < ((int)vector_2d.at(i).size()); j++)
        {
            std::cout << vector_2d.at(i).at(j) << " ";
        }
        std::cout << std::endl;
    }
    std::cout << std::endl;
    std::cout << std::endl;

    for (int i = 0; i < vec1_size; i++)
    {
        std::cout << vec1.at(i) << " ";
    };
    std::cout << std::endl;
    std::cout << std::endl;

    return 0;
}
