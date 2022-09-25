//
// Created by mdabr on 07.01.2022.
//

#include "game_controller.h"

#include <utility>


/*!
 * @brief Function generates pokemon classes used in the game
 *
 */

void Game_Controller::pokemon_pool_init() {
    pokemon_pool.emplace_back("Pikachu", 30, 30, 100, 100, Special_Attack("Thunderbolt", 50), 0, 2);
    pokemon_pool.emplace_back("Bulbasaur", 20, 25, 100, 100, Special_Attack("Vine Whip", 50), 0, 1);
    pokemon_pool.emplace_back("Charmander", 24, 20, 100, 100, Special_Attack("Ember", 50), 0, 3);
    pokemon_pool.emplace_back("Squirtle", 21, 30, 100, 100, Special_Attack("Water Gun", 50), 0, 0);
    pokemon_pool.emplace_back("Pidgey", 22, 20, 100, 100, Special_Attack("Wing Attack", 50), 0, 2);
    pokemon_pool.emplace_back("Rattata", 24, 20, 100, 100, Special_Attack("Bite", 50), 0, 1);
    pokemon_pool.emplace_back("Ekans", 18, 20, 100, 100, Special_Attack("Poison Sting", 50), 0, 1);
    pokemon_pool.emplace_back("Sandshrew", 20, 22, 100, 100, Special_Attack("Rock Throw", 50), 0, 5);
    pokemon_pool.emplace_back("Nidoran", 18, 21, 100, 100, Special_Attack("Bite", 50), 0, 5);
    pokemon_pool.emplace_back("Nidorina", 16, 10, 100, 100, Special_Attack("Poison Sting", 50), 0, 0);
    pokemon_pool.emplace_back("Nidoran", 15, 15, 100, 100, Special_Attack("Bite", 50), 0, 3);
    pokemon_pool.emplace_back("Nidorino", 20, 15, 100, 100, Special_Attack("Poison Sting", 50), 0, 1);
    pokemon_pool.emplace_back("Nidoking", 21, 10, 100, 100, Special_Attack("Poison Jab", 50), 0, 4);
    pokemon_pool.emplace_back("Rhyhorn", 23, 15, 100, 100, Special_Attack("Horn Attack", 50), 0, 4);
    pokemon_pool.emplace_back("Rhydon", 18, 15, 100, 100, Special_Attack("Horn Drill", 50), 0, 4);
    pokemon_pool.emplace_back("Kangaskhan", 18, 100, 100, 100, Special_Attack("Stomp", 50), 0, 1);
    pokemon_pool.emplace_back("Ponyta", 22, 15, 100, 100, Special_Attack("Stomp", 50), 0, 3);
    pokemon_pool.emplace_back("Rapidash", 23, 21, 100, 100, Special_Attack("Stomp", 50), 0, 1);
    pokemon_pool.emplace_back("Doduo", 22, 20, 100, 100, Special_Attack("Peck", 50), 0, 2);
    pokemon_pool.emplace_back("Dodrio", 19, 15, 100, 100, Special_Attack("Tri Attack", 50), 0, 2);
    pokemon_pool.emplace_back("Seel", 18, 15, 100, 100, Special_Attack("Icy Wind", 50), 0, 0);
    pokemon_pool.emplace_back("Dewgong", 15, 25, 100, 100, Special_Attack("Icy Wind", 50), 0, 0);
    pokemon_pool.emplace_back("Grimer", 28, 21, 100, 100, Special_Attack("Mud Slap", 50), 0, 5);
    pokemon_pool.emplace_back("Muk", 23, 12, 100, 100, Special_Attack("Mud Slap", 50), 0, 1);
    pokemon_pool.emplace_back("Shellder", 22, 22, 100, 100, Special_Attack("Bubble", 50), 0, 0);
    pokemon_pool.emplace_back("Cloyster", 22, 22, 100, 100, Special_Attack("Bubble Beam", 50), 0, 0);
    pokemon_pool.emplace_back("Gastly", 21, 15, 100, 100, Special_Attack("Lick", 50), 0, 2);
    pokemon_pool.emplace_back("Haunter", 22, 15, 100, 100, Special_Attack("Lick", 50), 0, 2);
    pokemon_pool.emplace_back("Gengar", 22, 23, 100, 100, Special_Attack("Shadow Ball", 50), 0, 2);
    pokemon_pool.emplace_back("Onix", 17, 5, 100, 100, Special_Attack("Rock Throw", 50), 0, 1);
    pokemon_pool.emplace_back("Drowzee", 17, 8, 100, 100, Special_Attack("Psybeam", 50), 0, 2);
}


/*!
 * @brief Constructor with default arguments provided in game_controller.h
 *
 * @param pokemonPool The pool of available pokemon classes, its also initialized in the constructor
 * @param playerTeam The team of the player
 * @param enemyTeam The team of the enemy, controlled by the computer
 *
 */

Game_Controller::Game_Controller(std::vector<Pokemon> pokemonPool, std::vector<Pokemon> playerTeam,
                                 std::vector<Pokemon> enemyTeam, int game_difficulty)
        : pokemon_pool(std::move(pokemonPool)),
          player_team(std::move(playerTeam)),
          enemy_team(std::move(enemyTeam)),
          game_difficulty(game_difficulty) {
    pokemon_pool_init();
}

/*!
 * @brief Destructor
 */

Game_Controller::~Game_Controller() = default;

/*!
 * @brief Prints all the pokemon in the pokemon_pool
 *
 */

void Game_Controller::print_pokemon_pool() const {
    for (int i = 0; i < pokemon_pool.size(); ++i) {
        std::cout << i + 1 << ". " << pokemon_pool[i].get_name() << " ";
    }
    std::cout << "\n";
}

/*!
 * @brief This function is used to pick pokemon to player team
 *
 * Player can choose to pick up to 6 pokemon
 */

void Game_Controller::pick_player_team() {
    std::cout << "Pick your team!\n";
    for (int i = 0; i < 6; ++i) {
        print_pokemon_pool();
        std::cout << "\n";
        std::cout << "Pokemon " << i + 1 << ": ";
        int choice = getInt(1, 30);
        player_team.emplace_back(pokemon_pool[choice - 1]);
        print_player_team();
        std::cout << std::endl;
    }
}

/*!
 * @brief Function gets integer from the keyboard safely
 *
 */

int Game_Controller::getInt(int start_bound, int end_bound) const {
    bool wise_choice = true;
    int choice {-2};
    do {
        try {
            std::cin >> choice;
            if (choice < start_bound || choice > end_bound) {
                throw std::invalid_argument("Invalid choice");
            }
            wise_choice = true;
        } catch (std::exception &e) {
            std::cout << "Invalid input!\n";
            std::cin.clear();
            std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
            wise_choice = false;
        }
    } while (!wise_choice);

    return choice;
}


/*!
 * @brief This function is picks pokemon to enemy team
 *
 */

void Game_Controller::randomize_enemy_team() {
    for (int i = 0; i < 6; ++i) {
        int random = rand() % pokemon_pool.size();
        enemy_team.emplace_back(pokemon_pool[random]);
    }
}


/*!
 * @brief Attack function
 *
 * @param attacker pokemon attacking class
 * @param defender pokemon defending class
 *
 * Attack can be dodged, efficiency of attack calculated depending on type of pokemon
 */

void Game_Controller::attack(Pokemon &attacker, Pokemon &defender) {
    std::cout << attacker.get_name() << " attacks " << defender.get_name() << "!\n";
    int damage = attacker.get_strength();
    buffer_damage_for_pokemon_type(attacker.get_type(), defender.get_type(), &damage);
    int def_agility = defender.get_agility();
    int random_number = rand() % 100;
    if (random_number < def_agility) {
        std::cout << defender.get_name() << " evaded the attack!\n";
    } else {
        defender.set_hp(defender.get_hp() - damage);
        int hp_left = defender.get_hp();
        if (hp_left < 0) {
            hp_left = 0;
            add_exp_for_kill(attacker);
        }
        std::cout << defender.get_name() << " has " << hp_left << " health left!\n";
    }
}


/*!
 * @brief This function is used to attack enemy pokemon, it has more damage than standard attack
 *
 * @param attacker pokemon attacking class
 * @param defender pokemon defending class
 *
 * Attack can be dodged but its harder to dodge than normal attack
 */

void Game_Controller::special_attack(Pokemon &attacker, Pokemon &defender) {
    std::cout << attacker.get_name() << " uses " << attacker.get_special_attack_name() << "!\n";
    int def_agility = defender.get_agility();
    int random_number = rand() % 100;
    random_number *= 1.5;
    if (random_number < def_agility) {
        std::cout << defender.get_name() << " evaded the attack!\n";
    } else {
        int damage = attacker.get_special_attack_damage();
        buffer_damage_for_pokemon_type(attacker.get_type(), defender.get_type(), &damage);
        defender.set_hp(defender.get_hp() - damage);
        int hp_left = defender.get_hp();
        if (hp_left < 0) {
            hp_left = 0;
            add_exp_for_kill(attacker);
        }
        std::cout << defender.get_name() << " has " << hp_left << " health left!\n";
    }
}

/*!
 * @brief This function is used to print the player team
 *
 *
 */


void Game_Controller::print_player_team() const {
    std::cout << std::endl;
    std::cout << "Player team: " << std::endl;
    for (int i = 0; i < player_team.size(); ++i) {
        std::cout << i + 1 << ". " << player_team[i].get_name() << " ";
    }
    std::cout << std::endl;
}

/*!
 * @brief This function is used to print the enemy team
 *
 *
 */

void Game_Controller::print_enemy_team() const {
    std::cout << std::endl;
    std::cout << "Enemy team: " << std::endl;
    for (int i = 0; i < enemy_team.size(); ++i) {
        std::cout << i + 1 << ". " << enemy_team[i].get_name() << " ";
    }
    std::cout << std::endl;
}

/*!
 * @brief: Its menu function for the player to choose what to do.
 *
 */

void Game_Controller::game_init(int *option) {
    while (*option != -1) {
        std::cout << std::endl;
        std::cout << "Choose an option:" << std::endl;
        std::cout << "1. Battle start" << std::endl;
        std::cout << "2. Pick difficulty" << std::endl;
        std::cout << "3. Change pokemon" << std::endl;
        std::cout << "4. Show my team" << std::endl;
        std::cout << "5. Show stats of pokemons in my team" << std::endl;
        std::cout << "6. Exit" << std::endl;
        std::cout << "Option: ";
        *option = getInt(1,6);


        switch (*option) {
            case 1:
                std::cout << std::endl;
                std::cout << "Battle start";
                battle_start();
                break;
            case 2:
                std::cout << std::endl;
                change_game_difficulty();
                std::cout << std::endl;
                break;
            case 3:
                std::cout << std::endl;
                change_pokemon_team();
                std::cout << std::endl;
                break;
            case 4:
                print_player_team();
                std::cout << std::endl;
                break;
            case 5: {
                std::cout << std::endl;
                for (int i = 0; i < player_team.size(); ++i) {
                    std::cout << "Pokemon " << i << std::endl;
                    player_team[i].print_stats();
                    std::cout << std::endl;
                }
                std::cout << std::endl;
                break;
            }
            case 6:
                *option = -1;
                break;
            default:
                break;
        }
    }
}


/*!
* \brief This is the main function of the game. It starts the battle between the player and the enemy.
*
*/

void Game_Controller::battle_start() {

    /*
     * initialize battle variables
     */

    difficulty_init();
    int player_team_hp = 0;
    int enemy_team_hp = 0;
    for (auto &i: player_team) {
        player_team_hp += i.get_hp();
    }
    for (auto &i: enemy_team) {
        enemy_team_hp += i.get_hp();
    }

    int player_pokemon_index = -1;
    int enemy_pokemon_index = 0;
    int player_action = 0;
    bool forfeit = false;

    print_enemy_team();
    print_player_team();
    player_pokemon_index = pick_pokemon(player_pokemon_index);
    std::cout << "Enemy chose: " << enemy_team[enemy_pokemon_index].get_name() << std::endl;


    while (player_team_hp > 0 && enemy_team_hp > 0) {

        /*
        * Player team action
        */

        if (player_team_hp <= 0) {
            std::cout << "Your team fainted! You lose!" << std::endl;
            break;
        }

        if (player_team[player_pokemon_index].get_hp() <= 0) {
            std::cout << "Your pokemon fainted! Choose another one!" << std::endl;
            print_player_team();
            player_pokemon_index = pick_pokemon(player_pokemon_index);
        }

        show_actions();
        std::cout << "Choose your action: ";
        player_action = getInt(1,5);

        switch (player_action) {
            case 1:
                attack(player_team[player_pokemon_index], enemy_team[enemy_pokemon_index]);
                break;
            case 2:
                special_attack(player_team[player_pokemon_index], enemy_team[enemy_pokemon_index]);
                break;
            case 3:
                evolve_pokemon(player_team[player_pokemon_index]);
                break;
            case 4:
                pick_pokemon(player_pokemon_index);
                break;
            case 5:
                forfeit = true;
                std::cout << "You forfeited the battle!" << std::endl;
                break;
            default:
                break;
        }

        /*
         * Enemy team action
         */

        if (forfeit) {
            break;
        }

        if (enemy_team_hp <= 0) {
            std::cout << "Enemy team fainted! You won!" << std::endl;
            break;
        }

        if (enemy_team[enemy_pokemon_index].get_hp() <= 0) {
            std::cout << "Enemy pokemon fainted! Choose another one!" << std::endl;
            enemy_pokemon_index++;
        }

        std::cout << "Enemy chose: " << enemy_team[enemy_pokemon_index].get_name() << std::endl;

        attack(enemy_team[enemy_pokemon_index], player_team[player_pokemon_index]);


        /*
         * brief Updating pokemon levels after a round
         */

        check_pokemon_exp();

    }
}

/*!
 *
 * \brief This function is used to pick new pokemon for the player.
 * @param player_pokemon_index
 * @return integer index of the player's pokemon in playerTeam vector
 *
 */

int Game_Controller::pick_pokemon(int player_pokemon_index) {
    while (player_pokemon_index - 1 < 0 || player_pokemon_index > player_team.size() ||
           player_team[player_pokemon_index - 1].get_hp() <= 0) {
        std::cout << "Choose your pokemon: ";
        player_pokemon_index = getInt(1, 6);
        std::cout << std::endl;
        if (player_team[player_pokemon_index - 1].get_hp() <= 0) {
            std::cout << "Your pokemon fainted! Choose another one!" << std::endl;
            continue;
        }
        std::cout << "You chose: " << player_team[player_pokemon_index - 1].get_name() << std::endl;
    }
    return player_pokemon_index - 1;
}

/*!
 *
 * \brief This function prints possible actions for the player.
 *
 */

void Game_Controller::show_actions() const {
    std::cout << std::endl;
    std::cout << "Choose your action: " << std::endl;
    std::cout << "1. Attack" << std::endl;
    std::cout << "2. Special attack" << std::endl;
    std::cout << "3. Evolve pokemon" << std::endl;
    std::cout << "4. Change pokemon" << std::endl;
    std::cout << "5. Run" << std::endl;
    std::cout << std::endl;
}

/*!
 * \brief Getter for game difficulty
 * @return integer representing game difficulty
 */

int Game_Controller::get_game_difficulty() const {
    return game_difficulty;
}

/*!
 * \brief Setter for game difficulty
 * @param option integer representing game difficulty
 */

void Game_Controller::set_game_difficulty(int option) {
    switch (option) {
        case 1:
            game_difficulty = 1;
            break;
        case 2:
            game_difficulty = 2;
            break;
        case 3:
            game_difficulty = 3;
            break;
        default:
            break;
    }
}

/*!
 * \brief Function changes game difficulty by the player's choice
 */

void Game_Controller::change_game_difficulty() {
    int picked_difficulty = 0;
    std::cout << "Choose difficulty: " << std::endl;
    std::cout << "1. Easy" << std::endl;
    std::cout << "2. Medium" << std::endl;
    std::cout << "3. Hard" << std::endl;
    picked_difficulty = getInt(1, 3);
    std::cout << std::endl;
    set_game_difficulty(picked_difficulty);
    std::cout << "Difficulty set to: " << get_game_difficulty() << std::endl;
}

/*!
 * \brief Function change pokemon in the team by the player's choice
 */

void Game_Controller::change_pokemon_team() {
    print_player_team();
    int swap_pokemon = 0;
    std::cout << "Choose pokemon to swap: " << std::endl;
    swap_pokemon = getInt(1, 6);
    std::cout << std::endl;
    print_pokemon_pool();
    int picked_pokemon = 0;
    std::cout << "Choose pokemon you want: " << std::endl;
    picked_pokemon = getInt(1, 6);
    std::cout << std::endl;
    swap_pokemon_in_team(swap_pokemon, picked_pokemon);
    std::cout << "Pokemon swapped!" << std::endl;
}

/*!
 * \brief Function used in change_pokemon_team() to swap pokemon in the team
 */

void Game_Controller::swap_pokemon_in_team(int pokemon, int pokemon1) {
    std::vector<Pokemon> temp_team;
    for (int i = 0; i < player_team.size(); ++i) {
        if ((pokemon - 1) == i) {
            temp_team.push_back(player_team[pokemon1 - 1]);
            continue;
        }
        temp_team.push_back(player_team[i]);
    }
    set_player_team(temp_team);
}

/*!
 * \brief Function used to adjust pokemon stats based on difficulty
 *
 * It's executed in battle_start() function
 */

void Game_Controller::difficulty_init() {
    if (game_difficulty == 1) {
        for (auto &i: enemy_team) {
            i.set_hp(i.get_hp() * 1);
            i.set_max_hp(i.get_max_hp() * 1);
        }
    } else if (game_difficulty == 2) {
        for (auto &i: enemy_team) {
            i.set_hp(i.get_hp() * 2);
            i.set_max_hp(i.get_max_hp() * 2);
        }
    } else if (game_difficulty == 3) {
        for (auto &i: enemy_team) {
            i.set_hp(i.get_hp() * 3);
            i.set_max_hp(i.get_max_hp() * 3);
        }
    }
}

/*!
 * \brief Function used to check if pokemon are ready to level up
 */

void Game_Controller::check_pokemon_exp() {
    for (auto &i: player_team) {
        if (i.get_experience() > i.get_xp_required()) {
            i.level_up();
            i.set_experience(i.get_experience() - i.get_xp_required());
            std::cout << i.get_name() << " leveled up!" << std::endl;
        }
    }
    for (auto &i: enemy_team) {
        if (i.get_experience() > i.get_xp_required()) {
            i.level_up();
            i.set_experience(i.get_experience() - i.get_xp_required());
            std::cout << i.get_name() << " leveled up!" << std::endl;
        }
    }
}

/*!
 * \brief This function is called when a pokemon is killed.
 * It adds the experience to pokemon that killed another pokemon.
 */

void Game_Controller::add_exp_for_kill(Pokemon &pokemon) {
    pokemon.add_experience(30);

}

/*!
 * \brief Function used to check the type of pokemon and adjust dmg accordingly
 */

void Game_Controller::buffer_damage_for_pokemon_type(int attacker_type, int defender_type, int *dmg) {
    double multiplier = pokemon_type_influence[attacker_type][defender_type];
    *dmg = (*dmg) * multiplier;
}

/*!
 * \brief Setter for player team
 */

void Game_Controller::set_player_team(std::vector<Pokemon> new_player_team) {
    this->player_team = std::move(new_player_team);
}

/*!
 * \brief Function adds stats to pokemon
 *
 * It randomize gained stats and adds them to pokemon
 */

void Game_Controller::evolve_pokemon(Pokemon &pokemon) {
    std::cout << "Pokemon evolved!" << std::endl;
    int exp_to_add = rand() % 50 + 1;
    pokemon.add_experience(exp_to_add);
    std::cout << "Pokemon gained " << exp_to_add << " experience!" << std::endl;
    int hp_to_add = rand() % 20 + 1;
    pokemon.set_hp(pokemon.get_hp() + hp_to_add);
    std::cout << "Pokemon gained " << hp_to_add << " hp!" << std::endl;
    pokemon.set_max_hp(pokemon.get_max_hp() + hp_to_add);
    std::cout << "Pokemon gained " << hp_to_add << " max hp!" << std::endl;
    pokemon.set_agility(pokemon.get_agility() + 2);
    std::cout << "Pokemon gained 2 agility!" << std::endl;
    pokemon.set_strength(pokemon.get_strength() + 2);
    std::cout << "Pokemon gained 2 strength!" << std::endl;
    check_pokemon_exp();
}
