#include <iostream>
#include <iostream>
#include <limits>

//board array 3x3
char board[3][3] = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};

//variables
char turn = 'X';
int choice;
int row;
int column;
bool isBoardFull;

//Board display function
void displayBoard(){
    std::cout << "\n\n";
    std::cout << "                          |     |     \n";
    std::cout << "                        "   << board[0][0] << " |  "  << board[0][1] << "  |  " << board[0][2] << " \n";
    std::cout << "                     _____|_____|_____\n";
    std::cout << "                          |     |     \n";
    std::cout << "                        "   << board[1][0] << " |  "  << board[1][1] << "  |  " << board[1][2] << " \n";
    std::cout << "                     _____|_____|_____\n";
    std::cout << "                          |     |     \n";
    std::cout << "                        "   << board[2][0] << " |  "  << board[2][1] << "  |  " << board[2][2] << " \n";
    std::cout << "                          |     |     \n\n";
}



void playerTurn(){

    if(turn == 'X'){
        std::cout << "                      Player(1) [X] turn : ";
    }
    else if(turn == 'O'){
        std::cout << "                      Player(2) [O] turn : ";
    }

    //Now let's get user input, and update the board according to player's choice, ensuring valid input
    if (!(std::cin >> choice)) {

        std::cout << "Invalid input! Please enter a valid number!\n";

        std::cin.clear();
        std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
        playerTurn();
        return;
    }

    //switch case to update appropriate column/row

    switch(choice) {
        case 1: row = 0; column = 0; break;
        case 2: row = 0; column = 1; break;
        case 3: row = 0; column = 2; break;
        case 4: row = 1; column = 0; break;
        case 5: row = 1; column = 1; break;
        case 6: row = 1; column = 2; break;
        case 7: row = 2; column = 0; break;
        case 8: row = 2; column = 1; break;
        case 9: row = 2; column = 2; break;
        default: std::cout << "Invalid input! Please enter a valid number!";
    }

    //conditions to update position to 'X' or 'O' if not already occupied
    if(turn == 'X' && board[row][column] != 'X' && board[row][column] !='O'){

        board[row][column] = 'X';
        turn = 'O';

    } else if(turn == 'O' && board[row][column] != 'O' && board[row][column] != 'X'){

        board [row][column] = 'O';
        turn = 'X';
    } else {    //if already filled
        std::cout << "Position is occupied, try another!\n";
        playerTurn();
    }
    
}


bool isGameOver(){
    
    //Column and row simple verification
    for(int i = 0; i < 3; i++){
        if(board[i][0] == board[i][1] && board[i][0] == board[i][2] || board[0][i] == board[1][i] && board[0][i] == board[2][i]){
        return true; //meaning game is finished
        }
    }
    

    //Diagonal checks
    if(board[0][0] == board[1][1] && board[0][0] == board[2][2] || board[0][2] == board[1][1] && board[0][2] == board[2][0]){
        return true; // game finished 
    }

    //Draw checks
    isBoardFull = true;
    for(int i = 0; i < 3; i++){
       for(int j = 0; j < 3; j++){
            if(board[i][j] != 'X' && board[i][j] != 'O'){
                isBoardFull = false; //There are still empty spaces on the board
            }
        }
    }
    //If the board is full, and no player has won (no conditions were met), it's a draw!  
    return isBoardFull;
}


void gameMessages(){

    displayBoard();  //to display final play before win or draw

    if(turn == 'X' && isBoardFull == false) {
        std::cout << "PLAYER 2 Wins!\n";
    } else if(turn == 'O' && isBoardFull == false){
        std::cout << "PLAYER 1 Wins!\n";
    } else{
        std::cout << "Game DRAW!\n";
    }
}
