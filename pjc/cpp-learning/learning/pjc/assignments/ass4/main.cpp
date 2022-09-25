#include <iostream>
#include <string>

template<typename T>
struct Node {
    T data{};
    Node *next{};
};

template<typename T>
void showList(const Node<T> *head) {
    while (head) {
        std::cout << head->data << " ";
        head = head->next;
    }
    std::cout << std::endl;
}

template<typename T>
Node<T> *arrayToList(const T a[], size_t size) {
    Node<T> *head = nullptr;
    Node<T> *tail = nullptr;
    for (size_t i = 0; i < size; ++i) {
        Node<T> *node = new Node<T>;
        node->data = a[i];
        if (head == nullptr) {
            head = node;
        } else {
            tail->next = node;
        }
        tail = node;
    }
    return head;
}

template<typename T>
void deleteList(Node<T> *&head) {
    while (head) {
        std::cout << "DEL:" << head->data << " ";
        auto *next = head->next;
        delete head;
        head = next;
    }
    std::cout << std::endl;
}

bool isLong(const std::string &s) { return s.size() >= 5; }

template<typename T, typename Pred>
Node<T> *extract(Node<T> *&head, Pred pred) {
    Node<T> *newHead = nullptr;
    Node<T> *newTail = nullptr;
    auto *head2 = head;

    while (head2) {
        if (pred(head2->data)) {
            auto *node = new Node<T>;
            node->data = head2->data;
            if (newHead == nullptr) {
                newHead = node;
            } else {
                newTail->next = node;
            }
            newTail = node;
        }
        auto *next = head2->next;
        head2 = next;
    }
    return newHead;
}


int main() {
    int tabi[] = {2, 1, 4, 3, 6, 5, 7, 8};
    size_t sizei = sizeof(tabi) / sizeof(tabi[0]);
    Node<int> *listAi = arrayToList(tabi, sizei);
    showList(listAi);
    Node<int> *listBi = extract(listAi, [](int n) { return n % 2 == 0; });
    showList(listBi);
    showList(listAi);
    deleteList(listBi);
    deleteList(listAi);
    std::string tabs[]{"Kasia", "Ola", "Ala", "Zosia", "Ela", "Basia"};
    size_t sizes = sizeof(tabs) / sizeof(tabs[0]);
    Node<std::string> *listAs = arrayToList(tabs, sizes);
    showList(listAs);
    Node<std::string> *listBs = extract(listAs, isLong);
    showList(listBs);
    showList(listAs);
    deleteList(listBs);
    deleteList(listAs);
}
