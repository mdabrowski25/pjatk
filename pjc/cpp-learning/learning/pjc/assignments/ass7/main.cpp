#include <iostream>

template<typename F, typename S>
class Pair {
    F fst;
    S scn;
public:
    Pair(F f, S s) : fst(f), scn(s) {}

    Pair(const Pair& p) : fst(p.fst), scn(p.scn) {}

    Pair(Pair<int, int>& pair) {
        fst = static_cast<F>(pair.first());
        scn = static_cast<S>(pair.second());
    }

    F first() { return fst; }

    S second() { return scn; }

    friend std::ostream& operator<<(std::ostream& os, const Pair& p) {
        os << "(" << p.fst << ", " << p.scn << ")";
        return os;
    }

    bool operator<(const Pair& p) const {
        bool result = false;
        if (fst < p.fst) {
            result = true;
        }
        else if (fst == p.fst) {
            if (scn < p.scn) {
                result = true;
            }
        }
        return result;
    }

    bool operator>(const Pair& p) const {
        bool result = false;
        if (fst > p.fst) {
            result = true;
        }
        else if (fst == p.fst) {
            if (scn > p.scn) {
                result = true;
            }
        }
        return result;
    }

    bool operator<=(const Pair& p) const {
        bool result = false;
        if (fst < p.fst) {
            result = true;
        }
        else if (fst == p.fst) {
            if (scn <= p.scn) {
                result = true;
            }
        }
        return result;
    }

    bool operator>=(const Pair& p) const {
        bool result = false;
        if (fst > p.fst) {
            result = true;
        }
        else if (fst == p.fst) {
            if (scn >= p.scn) {
                result = true;
            }
        }
        return result;
    }

    bool operator==(const Pair& p) const {
        bool result = false;
        if (fst == p.fst && scn == p.scn) {
            result = true;
        }
        return result;
    }

    bool operator!=(const Pair& p) const {
        bool result = false;
        if (fst != p.fst || scn != p.scn) {
            result = true;
        }
        return result;
    }

};


template<typename PAIR>
void check(const PAIR& lhs, const PAIR& rhs) {
    using std::cout; using std::endl;auto flags = cout.flags();
    cout << std::boolalpha;
    cout << "\nLHS=" << lhs << "  RHS=" << rhs << endl;
    cout << "lhs <  rhs: " << (lhs < rhs) << endl;
    cout << "lhs <= rhs: " << (lhs <= rhs) << endl;
    cout << "lhs >  rhs: " << (lhs > rhs) << endl;
    cout << "lhs >= rhs: " << (lhs >= rhs) << endl;
    cout << "lhs == rhs: " << (lhs == rhs) << endl;
    cout << "lhs != rhs: " << (lhs != rhs) << endl;
    cout.flags(flags);
}

int main() {
    check(Pair<int, int>(3, 3), Pair<int, int>(4, 2));
    check(Pair<int, int>(3, 3), Pair<int, int>(3, 2));
    check(Pair<int, int>(4, 3), Pair<int, int>(4, 3));
    Pair<int, int> pia{ 3, 4 };
    Pair<int, int> pib{ 4, 5 };
    Pair<double, double> pd(pia);
    std::cout << pia << std::endl;
    std::cout << pd << std::endl;
    pd = pib;
    std::cout << pd << std::endl;
}
