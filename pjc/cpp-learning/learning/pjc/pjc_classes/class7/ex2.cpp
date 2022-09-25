#include <iostream>
#include <cstring>

class Person {
    char* name;
    friend class Couple;
public:
    explicit Person(const char* n);
    Person(const Person& os);
    Person& operator=(const Person& os) {
        if (this != &os) {
            delete[] name;
            name = new char[strlen(os.name) + 1];
            strcpy(name, os.name);
        }
        return *this;
    };
    ~Person();
    friend std::ostream& operator<<(std::ostream& str, const Person& os) {
        str << os.name;
        return str;
    };
};

class Couple {
    Person* wife, * husband;
public:Couple(const Person& she, const Person& he);
      Couple(const Couple& other);
      Couple& operator=(const Couple& other) {
          if (this != &other) {
              delete wife;
              delete husband;
              wife = new Person(*other.wife);
              husband = new Person(*other.husband);
          }
          return *this;
      };
      ~Couple();
      friend std::ostream& operator<<(std::ostream& str, const Couple& p) {
          str << "(" << *p.wife << "," << *p.husband << ")";
          return str;
      };
};

int main(void) {
    using std::cout;
    using std::endl;
    Person* pjohn = new Person("John"), * pjane = new Person("Jane");
    Person mary("Mary"), mark("Mark");
    Couple* pcouple1 = new Couple(mary, *pjohn);
    Couple couple2(*pjane, mark);
    delete pjohn;
    delete pjane;
    cout << *pcouple1 << endl;
    cout << couple2 << endl;
    couple2 = *pcouple1;
    delete pcouple1;
    cout << couple2 << endl;
}

Person::~Person() {
    std::cout << "Person destructor called for " << name << std::endl;
}

Person::Person(const char* n) {
    name = new char[strlen(n) + 1];
    strcpy(name, n);
}

Person::Person(const Person& os) {
    name = new char[strlen(os.name) + 1];
    strcpy(name, os.name);
}

Couple::Couple(const Person& she, const Person& he) {
    wife = new Person(she);
    husband = new Person(he);
}

Couple::Couple(const Couple& other) {
    wife = new Person(*other.wife);
    husband = new Person(*other.husband);
}



