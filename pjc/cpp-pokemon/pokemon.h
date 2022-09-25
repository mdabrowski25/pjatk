//
// Created by mdabr on 07.01.2022.
//

#ifndef PROJECT_POKEMON_H
#define PROJECT_POKEMON_H

#include <string>
#include <iostream>
#include "special_attack.h"


/*!
 * \brief The pokemon header class
 *
 * This class is used to create a pokemon object.
 *
 * Methods implementation in pokemon.cpp
 *
 * Managed by Game_Controller
 */

class Pokemon {
private:
    std::string name;
    int strength;
    int agility;
    int hp;
    int max_hp;
    Special_Attack special;
    int experience;
    int level;
    /*!
     * \brief type
     *
     * Used to declare pokemon type
     *
     * 0. WATER,
     * 1. GROUND,
     * 2. AIR,
     * 3. FIRE,
     * 4. ICE,
     * 5. STEEL,
     * 6. NONE
     */
     int type;

public:
    Pokemon(std::string name = "None", int strength = 0, int agility = 0, int hp = 0, int max_hp = 100,
            Special_Attack special = Special_Attack("None", 0), int experience = 0, int level = 0,
            int type = 0);

    Pokemon(const Pokemon &source);

    Pokemon(Pokemon &&source) noexcept;

    ~Pokemon();

    std::string get_name() const;

    int get_strength() const;

    int get_agility() const;

    int get_hp() const;

    std::string get_special_attack_name() const;

    int get_special_attack_damage() const;

    int get_type() const;

    void add_experience(int exp);

    void level_up();

    void print_stats() const;

    void set_hp(int newHp);

    void set_max_hp(int newMaxHp);

    int get_max_hp() const;

    int get_experience() const;

    int get_level() const;

    void set_level(int newLevel);

    void set_experience(int newExp);

    int get_xp_required();

    void set_agility(int newAgility);

    void set_strength(int newStrength);

};

#endif //PROJECT_POKEMON_H
