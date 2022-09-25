//
// Created by mdabr on 07.01.2022.
//

#ifndef PROJECT_GAME_CONTROLLER_H
#define PROJECT_GAME_CONTROLLER_H

#include <vector>
#include "pokemon.h"
#include <random>
#include <string>

/**
 * @brief The GameController class
 *
 * This class is responsible for the game logic.
 * It contains the game loop and the game logic.
 *
 */

class Game_Controller {
private:
    std::vector<Pokemon> pokemon_pool;
    std::vector<Pokemon> player_team;
    std::vector<Pokemon> enemy_team;
    int game_difficulty;

    /**
     * @brief Two dimensional table contains multiplier for dmg calculation
     *
     * First index represents the type of the pokemon --> 0 = WATER, 1 = GROUND, 2 = AIR, 3 = FIRE, 4 = ICE, 5 = STEEL, 6 = NONE
     * Second index represents the type of the defending pokemon and provides the dmg multiplier
     *
     */

    double pokemon_type_influence[7][7] = {
            {0.5, 1.5, 1, 1.5, 1, 1, 1},
            {1, 1, 0.5, 1.5, 1.5, 1.5, 1},
            {1, 0.5, 1, 1, 1.5, 0.5, 1},
            {0.5, 0.5, 1, 1, 1.5, 1.5, 1},
            {0.5, 1.5, 1, 0.5, 0.5, 1, 1},
            {1.5, 1, 1.5, 0.5, 1, 0.5, 1},
            {0, 0, 0, 0, 0, 0, 0}
    };

public:
    Game_Controller(std::vector<Pokemon> pokemon_pool = {}, std::vector<Pokemon> player_team = {},
                    std::vector<Pokemon> enemy_team = {}, int game_difficulty = 1);

    ~Game_Controller();

    void pokemon_pool_init();

    void pick_player_team();

    void randomize_enemy_team();

    void print_pokemon_pool() const;

    void attack(Pokemon &attacker, Pokemon &defender);

    void special_attack(Pokemon &attacker, Pokemon &defender);

    void game_init(int *option);

private:
    void print_player_team() const;

    void print_enemy_team() const;

    void battle_start();

    void show_actions() const;

    int pick_pokemon(int player_pokemon_index);

    void set_game_difficulty(int option);

    void change_game_difficulty();

    int get_game_difficulty() const;

    void change_pokemon_team();

    void swap_pokemon_in_team(int pokemon, int pokemon1);

    void difficulty_init();

    void check_pokemon_exp();

    void add_exp_for_kill(Pokemon &pokemon);

    void buffer_damage_for_pokemon_type(int attacker_type, int type1, int *pInt);

    void set_player_team(std::vector<Pokemon> new_player_team);

    void evolve_pokemon(Pokemon &pokemon);

    int getInt(int start_bound, int end_bound) const;
};

#endif //PROJECT_GAME_CONTROLLER_H
