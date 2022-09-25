#include <iostream>
#include <vector>
#include "game_controller.h"

using namespace std;

void start_game_loop(Game_Controller game_controller);

int main()
{
    /*!
    * \brief Game initialization
    */

    Game_Controller game_controller = Game_Controller();

    game_controller.pick_player_team();
    game_controller.randomize_enemy_team();

    start_game_loop(game_controller);

    return 0;
}

void start_game_loop(Game_Controller game_controller)
{
    cout << endl;

    /*!
    * \brief Game loop
    */

    int *option = new int;
    game_controller.game_init(option);

    /*!
     * \brief Deallocate memory
     */

    delete option;

}