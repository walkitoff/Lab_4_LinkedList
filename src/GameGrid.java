import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class GameGrid {
    int[][] aiGrid = new int[10][10];
    String[][] aiBoard = new String[10][10]; //maybe replace with linkedList
    SecureRandom oRand = new SecureRandom();
    int iWallChance;
    int iTemp;
    int iMoves = 0; //count moves made

    //game & board pieces
    String wall = "\u274C"; //red X
    String clearedSpace = "\u2705"; //Green check mark
    String boat = "\u26F5";  //boat
    String boardPiece = "\u2652";  //purple water

    //game state
    int iUserRow = 0;
    int iUserCol = 0;
    char uInput;
    Scanner sc = new Scanner(System.in);

    public void run() {
        iWallChance  = oRand.nextInt(16) + 10; // random 15-25 %
        System.out.println("WALL CHANCE: " + iWallChance + "%");

        //fill aiBoard  aka display board
        for (String[] row : aiBoard) {
            Arrays.fill(row, boardPiece);
        }

        //set initial game board  aka the hidden walls and open spaces
        for (int y = 0; y < aiGrid.length; y++) {
            for (int x = 0; x < aiGrid[y].length; x++) {
                iTemp = oRand.nextInt(100) + 1;  // random 1 - 100
                if (y == 0 && x == 0) {
                    aiGrid[y][x] = 0;
                    aiBoard[y][x] = boat;
                } else if (iTemp < iWallChance) {
                    aiGrid[y][x] = 1;
                } else {
                    aiGrid[y][x] = 0;
                }
            }
        }

        printGameBoard();

        while (true) {
            System.out.println("Type 'R' for right or 'D' for down: ");
            uInput = Character.toUpperCase(sc.next().charAt(0));  //get user input, grab only 1st letter of string input

            if (uInput == 'R') {
                //1st checks for a wall in the space attempting to move into
                if (aiGrid[iUserCol][iUserRow + 1] == 1) {
                    aiBoard[iUserCol][iUserRow + 1] = wall;  //displays the wall that was hit
                   printGameBoard();
                    break;
                } else { //2nd: if 1st is not a wall do this:
                    aiBoard[iUserCol][iUserRow] = clearedSpace;
                    iUserRow++;
                    aiBoard[iUserCol][iUserRow] = boat;
                }
            }else if (uInput == 'D') { //same as above but for 'D' instead of 'R'
                if (aiGrid[iUserCol + 1][iUserRow] == 1) {
                    aiBoard[iUserCol + 1][iUserRow] = wall;
                    printGameBoard();
                    break;
                } else {
                    aiBoard[iUserCol][iUserRow] = clearedSpace;
                    iUserCol++;
                    aiBoard[iUserCol][iUserRow] = boat;
                }
            }

            printGameBoard();

            if(iUserRow == 9 || iUserCol == 9){
                System.out.println("***********************");
                System.out.println("        YOU WIN        ");
                System.out.println("***********************");
                System.exit(0);
            }

        }
        System.out.println("GAME OVER....YOUR SHIP HIT A WALL!!!!");
    }


    public void printGameBoard(){
        for (int y = 0; y < aiBoard.length; y++) {
            for (int x = 0; x < aiBoard[y].length; x++){
                System.out.printf("%2s", aiBoard[y][x]);
            }
            //displays answers if you win
            if(iUserRow == 9 || iUserCol == 9) {
                System.out.print("\t");
                for (int x = 0; x < aiGrid[y].length; x++) {
                    System.out.printf("%3s", aiGrid[y][x]);
                }
            }
            System.out.println();
        }
    }


}
