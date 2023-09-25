#include <iostream>
#include <stdlib.h>
#include "tictac.hpp"

// Little project developed while completing Code Academy C++ development course! 25/09/2023
//Good practice!

int main(){

std::cout << "\n             Welcome to @dovalealves TIC--TAC--TOE Game!\n\n";
std::cout << "             ############-2 PLAYERS REQUIRED-############\n\n";
std::cout << "                  Player(1) [X]    Player(2) [O]\n";


while (!isGameOver()){

    displayBoard();
    playerTurn();
    isGameOver();
}

gameMessages();


}