#include <iostream>
#include <string>
#include <ctime>
#include <iterator>

struct Node {
    int data;
    Node *next;
};

Node *arrayToList(const int arr[], size_t size) {
    Node *head = nullptr;
    Node *tail = nullptr;
    for (size_t i = 0; i < size; ++i) {
        Node *node = new Node;
        node->data = arr[i];
        node->next = nullptr;
        if (head == nullptr) {
            head = node;
            tail = node;
        } else {
            tail->next = node;
            tail = node;
        }
    }
    return head;
}

Node *removeOdd(Node *head) {
    Node *odd = nullptr;
    Node *even = nullptr;
    Node *evenTail = nullptr;
    Node *oddTail = nullptr;
    int counter = 0;
    while (head != nullptr) {

        if (head->data % 2 == 0) {
            if (even == nullptr) {
                even = head;
                evenTail = even;
            } else {
                evenTail->next = head;
                evenTail = evenTail->next;
            }
        } else {
            std::cout << "DEL:" << head->data << " ";
            if (odd == nullptr) {
                odd = head;
                oddTail = odd;
            } else {
                oddTail->next = head;
                oddTail = oddTail->next;
            }
        }
        head = head->next;
    }
    std::cout << std::endl;

    return even;
}

void showList(const Node *head) {
    if (head == nullptr) {
        std::cout << "Empty list" << std::endl;
        return;
    }

    while (head) {
        std::cout << head->data << " ";
        head = head->next;
    }
    std::cout << std::endl;
}

void deleteList(Node *&head) {
    while (head) {
        Node *temp = head;
        std::cout << "DEL:" << head->data << " ";
        head = head->next;
        delete temp;
    }
    std::cout << std::endl;
}

int main() {
    int arr[] = {1, 2, 3, 4, 5, 6};
    size_t size = sizeof(arr) / sizeof(*arr);
    Node *head = arrayToList(arr, size);
    showList(head);
    head = removeOdd(head);
    showList(head);
    deleteList(head);
    showList(head);
}