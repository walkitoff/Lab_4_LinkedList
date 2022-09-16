import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class GameGrid {
    LinkedList uPath = new LinkedList();
    Scanner sc = new Scanner(System.in);

    int[][] aiGrid = new int[10][10];
    String[][] gameBoard = new String[10][10]; //maybe replace with linkedList
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
    boolean winLoss = false;
    int iUserRow = 0;
    int iUserCol = 0;
    char uInput;

    public void run() {
        iWallChance  = oRand.nextInt(11) + 10; // random 10-20 %
        System.out.println("WALL CHANCE: " + iWallChance + "%");

        //fill gameBoard with purple water
        for (String[] row : gameBoard) {
            Arrays.fill(row, boardPiece);
        }

        /**
         * FILL/SET initial game
         * walls, spaces and player start location
         */
        for (int y = 0; y < aiGrid.length; y++){
            for (int x = 0; x < aiGrid[y].length; x++) {
                iTemp = oRand.nextInt(100) + 1;  // random 1 - 100
                if (y == 0 && x == 0) {
                    aiGrid[y][x] = 0;
                    gameBoard[y][x] = boat;
                    uPath.addHeadNode(y, x);  /** TRACK PLAYER START POINT */
                } else if (iTemp < iWallChance) {
                    aiGrid[y][x] = 1;
                } else {
                    aiGrid[y][x] = 0;
                }
            }
        }


        printGameBoard();
        while (!winLoss) {
            System.out.println("Type 'R' for right or 'D' for down: ");
            uInput = Character.toUpperCase(sc.next().charAt(0));  //get user input, grab only 1st letter of string input

            if (uInput == 'R') {
                //1st checks for a wall in the space attempting to move into
                if (aiGrid[iUserCol][iUserRow + 1] == 1) {
                    gameBoard[iUserCol][iUserRow + 1] = wall;
                    winLoss = true; //set to true because user lost.
                } else { //2nd: if 1st is not a wall move boat to that space
                    gameBoard[iUserCol][iUserRow] = boardPiece;
                    iUserRow++;
                    gameBoard[iUserCol][iUserRow] = boat;
                    uPath.addHeadNode(iUserCol, iUserRow); /** updates linkedList */
                    iMoves++;
                }
            }else if (uInput == 'D') { //same as above but for 'D' instead of 'R'
                if (aiGrid[iUserCol + 1][iUserRow] == 1) {
                    gameBoard[iUserCol + 1][iUserRow] = wall;
                    winLoss = true; //set to true because user lost.
                } else {
                    gameBoard[iUserCol][iUserRow] = boardPiece;
                    iUserCol++;
                    gameBoard[iUserCol][iUserRow] = boat;
                    uPath.addHeadNode(iUserCol, iUserRow); /** updates linkedList */
                    iMoves++;
                }
            }
            printGameBoard();
        }

    }


    public void printGameBoard(){
        if(iUserRow == 9 || iUserCol == 9 || winLoss) {
            winLoss = true;
            /** get user's path from LinkedList */
            Node oNode = uPath.headNode;
            while(uPath.headNode != null){
                gameBoard[oNode.yPosition][oNode.xPosition] = clearedSpace;
                oNode = uPath.removeHeadNode();
            }
        }

        for (int y = 0; y < gameBoard.length; y++) {
            for (int x = 0; x < gameBoard[y].length; x++) {
                System.out.printf("%2s", gameBoard[y][x]);
            }
            System.out.println();
        }

        if(iUserRow == 9 || iUserCol == 9) {
            System.out.println("***********************");
            System.out.println("        YOU WIN        ");
            System.out.println("***********************");
            System.out.println("Total Moves: " + iMoves);
        }else if(winLoss){
            System.out.println("---------------------------------------");
            System.out.println(" GAME OVER....YOUR SHIP HIT A WALL!!!! ");
            System.out.println("---------------------------------------");
            System.out.println("Total Moves: " + iMoves);
        }

    }

}
