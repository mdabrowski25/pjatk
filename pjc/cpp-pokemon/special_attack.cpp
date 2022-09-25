//
// Created by mdabr on 07.01.2022.
//

#include "special_attack.h"

#include <utility>

/*!
 * @brief Constructor with provided default values from the header file.
 */

Special_Attack::Special_Attack(std::string name, int damage)
        : name(std::move(name)), damage(damage) {};

/*!
 * @brief Getter for the name of the special attack.
 * @return The name string of the special attack.
 */

std::string Special_Attack::get_name() const { return name; };

/*!
 * @brief Getter for the name of the special attack.
 * @return The damage of the special attack.
 */
int Special_Attack::get_damage() const { return damage; };

