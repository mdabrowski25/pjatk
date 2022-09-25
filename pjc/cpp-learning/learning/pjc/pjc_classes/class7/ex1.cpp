#include <iostream>
#include <string>

using namespace std;

class Author {
    size_t capacity;
    size_t numOfBooks;
    string  name;
    string* books;
public:
    Author(string n);
    Author(const Author& other);
    Author(Author&& other);
    void addBook(const string& book);
    void info() const;
    void changeName(const string& n);
    Author& operator=(const Author& other) {
        cout << "Assignment operator called" << endl;
        if (this != &other) {
            delete[] books;
            capacity = other.capacity;
            numOfBooks = other.numOfBooks;
            name = other.name;
            books = new string[capacity];
            for (size_t i = 0; i < numOfBooks; ++i) {
                books[i] = other.books[i];
            }
        }
        return *this;
    };
    Author& operator=(Author&& other) {
        cout << "Move assignment operator called" << endl;
        if (this != &other) {
            delete[] books;
            capacity = other.capacity;
            numOfBooks = other.numOfBooks;
            name = other.name;
            books = other.books;
            other.books = nullptr;
        }
        return *this;
    };
    ~Author();

};

int main() {
    Author ws("Shakespeare");
    ws.addBook("Macbeth");
    ws.addBook("Hamlet");
    ws.addBook("Othello");
    Author fb(move(ws));
    fb.changeName("Bacon");
    fb.addBook("Pericles");
    fb.addBook("Tempest");
    fb.info();ws = move(fb);
    ws.changeName("Shakespeare");
    fb = ws = ws;
    ws.info();
    fb.info();
}

Author::Author(string n)
    : capacity(2), numOfBooks(0), name(n), books(new string[capacity]) {}

Author::Author(const Author& other)
    : capacity(other.capacity), numOfBooks(other.numOfBooks), name(other.name), books(new string[capacity]) {
    for (size_t i = 0; i < numOfBooks; ++i) {
        books[i] = other.books[i];
    }
}

Author::Author(Author&& other)
    : capacity(other.capacity), numOfBooks(other.numOfBooks), name(other.name), books(other.books) {
    other.capacity = 0;
    other.numOfBooks = 0;
    other.name = "";
    other.books = nullptr;
}

void Author::addBook(const string& book) {
    if (numOfBooks == capacity) {
        capacity *= 2;
        string* newBooks = new string[capacity];
        for (size_t i = 0; i < numOfBooks; ++i) {
            newBooks[i] = books[i];
        }
        delete[] books;
        books = newBooks;
    }
    books[numOfBooks++] = book;
}

void Author::info() const {
    cout << "Author: " << name << endl;
    cout << "Books: ";
    for (size_t i = 0; i < numOfBooks; ++i) {
        cout << books[i] << " ";
    }
    cout << endl;
}


void Author::changeName(const string& n) {
    name = n;
}

Author::~Author() {}

