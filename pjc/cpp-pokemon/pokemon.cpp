//
// Created by mdabr on 07.01.2022.
//
#include "pokemon.h"

#include <utility>

/*!
 * @brief Constructor for the Pokemon class
 *
 */
Pokemon::Pokemon(std::string name, int strength, int agility, int hp, int max_hp, Special_Attack special,
                 int experience, int level,
                 int type) :
        name(std::move(name)), strength(strength), agility(agility), hp(hp), max_hp(max_hp),
        special(std::move(special)),
        experience(experience), level(level), type(type) {}


/*!
 * @brief Copy constructor for the Pokemon class
 *
 */

Pokemon::Pokemon(const Pokemon &source) {
    name = source.name;
    strength = source.strength;
    agility = source.agility;
    hp = source.hp;
    max_hp = source.max_hp;
    special = source.special;
    experience = source.experience;
    level = source.level;
    type = source.type;
}

/*!
 * @brief Move constructor for the Pokemon class
 *
 */

Pokemon::Pokemon(Pokemon &&source) noexcept {
    name = std::move(source.name);
    strength = source.strength;
    agility = source.agility;
    hp = source.hp;
    max_hp = source.max_hp;
    special = std::move(source.special);
    experience = source.experience;
    level = source.level;
    type = source.type;
}

/*!
 * @brief Destructor for the Pokemon class
 *
 */

Pokemon::~Pokemon() = default;


/*!
 * @brief getters for the Pokemon class
 *
 */

std::string Pokemon::get_name() const {
    return name;
}

int Pokemon::get_strength() const {
    return strength;
}

int Pokemon::get_agility() const {
    return agility;
}

int Pokemon::get_hp() const {
    return hp;
}

std::string Pokemon::get_special_attack_name() const {
    return special.get_name();
}

int Pokemon::get_special_attack_damage() const {
    return special.get_damage();
}

int Pokemon::get_type() const {
    return type;
}

int Pokemon::get_max_hp() const {
    return max_hp;
}

int Pokemon::get_experience() const {
    return experience;
}

int Pokemon::get_level() const {
    return level;
}

/*!
 * @brief setters for the Pokemon class
 *
 */

void Pokemon::set_hp(int newHp) {
    hp = newHp;
}

void Pokemon::set_max_hp(int newMaxHp) {
    max_hp = newMaxHp;
}


void Pokemon::set_level(int newLevel) {
    level = newLevel;
}

void Pokemon::set_experience(int newExperience) {
    experience = newExperience;
}


/*!
 * @brief Add experience to the pokemon
 *
 */

void Pokemon::add_experience(int exp) {
    experience += exp;
}

/*!
 * @brief Function level up the pokemon
 *
 */

void Pokemon::level_up() {
    level++;
    strength += 5;
    agility += 5;
    hp += 10;
    max_hp += 50;
}

/*!
 * @brief Function prints stats of the pokemon
 *
 */

void Pokemon::print_stats() const {
    std::cout << "Name: " << name << std::endl;
    std::cout << "Type: " << type << std::endl;
    std::cout << "Level: " << level << std::endl;
    std::cout << "HP: " << hp << std::endl;
    std::cout << "Max HP: " << max_hp << std::endl;
    std::cout << "Strength: " << strength << std::endl;
    std::cout << "Agility: " << agility << std::endl;
    std::cout << "Special Attack: " << special.get_name() << std::endl;
    std::cout << "Special Attack Damage: " << special.get_damage() << std::endl;
    std::cout << "Experience: " << experience << std::endl;
}

int Pokemon::get_xp_required() {
    return 150;
}

void Pokemon::set_agility(int newAgility) {
    agility = newAgility;
}

void Pokemon::set_strength(int newStrength) {
    strength = newStrength;
}
