//
// Created by mdabr on 07.01.2022.
//

#ifndef PROJECT_SPECIAL_ATTACK_H
#define PROJECT_SPECIAL_ATTACK_H

#include <string>

/*!
 * \brief The special attack class header
 *
 * This class is used to define and measure pokemon special attac
 *
 * Used and friended by Pokemon class
 */

class Special_Attack {
private:
    std::string name;
    int damage;

public:
    Special_Attack(std::string name = "not specified", int damage = 0);

    std::string get_name() const;

    int get_damage() const;
};

#endif //PROJECT_SPECIAL_ATTACK_H
