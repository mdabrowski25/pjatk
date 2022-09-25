#include <iostream>
#include <string>
#include <ctime>
#include <iterator>

template<typename T, typename FUN>
size_t part(T *arr, size_t size, FUN f) {
    size_t left = 0;
    size_t right = size - 1;
    while (left < right) {
        while (left < right && f(arr[left])) {
            ++left;
        }
        while (left < right && !f(arr[right])) {
            --right;
        }
        std::swap(arr[left], arr[right]);
    }
    return left;
}

template<typename T>
void printTab(const T *t, size_t size) {
    std::cout << "[ ";
    for (size_t i = 0; i < size; ++i) {
        std::cout << t[i] << " ";
    }
    std::cout << "]" << std::endl;
}

bool isEven(int e) { return e % 2 == 0; }

int main() {
    size_t ind = 0;

    int a1[] = {1, 2, 3, 4, 5, 6};
    ind = part(a1, 6, isEven);
    std::cout << "ind = " << ind << " ";
    printTab(a1, 6);

    int a2[] = {1, 2, 3, 4, 5, 6};
    // lambda as argument: a predicate checking
    // if the given number is odd
    ind = part(a2, std::size(a2), [](int e) { return e % 2 != 0; });
    std::cout << "ind = " << ind << " ";
    printTab(a2, std::size(a2));

    std::string a3[] = {"Ala", "Ula", "Ela", "Ola", "Maja"};
    std::string mn = "Bea";
    std::string mx = "Sue";
    // lambda as argument: a predicate checking
    // if the given name is in the range [mn,mx]
    ind = part(a3, std::size(a3), [&mn, &mx](const std::string &e) {
        return e >= mn && e <= mx;
    });
    std::cout << "ind = " << ind << " ";
    printTab(a3, std::size(a3));

    constexpr size_t DIM = 500000;
    int *a4 = new int[DIM];
    srand(unsigned(time(0)));
    for (size_t i = 0; i < DIM; ++i) a4[i] = rand() % 21 + 1;
    // lambda as argument: a predicate checking
    // if the given number is divisible by 7
    ind = part(a4, DIM, [](int e) { return e % 7 == 0; });
    std::cout << "ind = " << ind << std::endl;
    delete[] a4;
}