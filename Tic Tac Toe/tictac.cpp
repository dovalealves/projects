#include <iostream>


int main(){

 void displayBoard(char board[3][3]){
    std::cout << "  1 2 3" << "\n";
    for (int row = 0; row < 3; ++row) {
        std::cout << row + 1 << " ";
        for (int col = 0; col < 3; ++col) {
            std::cout << board[row][col];
            if (col < 2) {
                std::cout << "|"; // Vertical separator
            }
        }
        std::cout << std::endl;
        if (row < 2) {
            std::cout << "  -+-+-" << std::endl; // Horizontal separator
        }
    }
}
}