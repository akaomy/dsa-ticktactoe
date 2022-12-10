import java.util.*;

public class Main {
// steps:
//	1. Both the players choose either X or O to mark their cells.
//	2. There will be a 3×3 grid with numbers assigned to each of the 9 cells.
//	3. The player who chose X begins to play first.
//	4. He enters the cell number where he wishes to place X.
//	5. Now, both O and X play alternatively until any one of the two wins.
//	6. Winning criteria: Whenever any of the two players has fully filled 				 how to implement winning criteria?
//	one row/ column/ diagonal with his symbol (X/ O), he wins and the 
//	game ends.
//	7. If neither of the two players wins, the game is said to have ended 
//	in a draw.
	
	
	
//	criteria:
//	- two players are playing the game of Tic Tac Toe - names are placed in two queues first
//	- winners and losers are placed in two stacks
//	- generic sort to sort the winners by name or age
//	- binary tree to find a player by name
//	- hashing is used to find a player by age
//	- class player with name and age as member variables
	
	static String[] board;
    static String turn;
    // player 1: name and score
    // player 2: name and score
    
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		displayMenu(in);

		
//        board = new String[9];
//        turn = "X";
//        String winner = null;
// 
//        for (int a = 0; a < 9; a++) {
//            board[a] = String.valueOf(a + 1);
//        }
// 
//        printBoard();
// 
//        System.out.println(
//            "X will play first. Enter a slot number to place X in:");
// 
//        while (winner == null) {
//            int numInput;
//           
//           // Exception handling.
//           // numInput will take input from user like from 1 to 9.
//           // If it is not in range from 1 to 9.
//           // then it will show you an error "Invalid input."
//            try {
//                numInput = in.nextInt();
//                if (!(numInput > 0 && numInput <= 9)) {
//                    System.out.println(
//                        "Invalid input; re-enter slot number:");
//                    continue;
//                }
//            }
//            catch (InputMismatchException e) {
//                System.out.println(
//                    "Invalid input; re-enter slot number:");
//                continue;
//            }
//             
//            // This game has two player x and O.
//            // Here is the logic to decide the turn.
//            if (board[numInput - 1].equals(
//                    String.valueOf(numInput))) {
//                board[numInput - 1] = turn;
// 
//                if (turn.equals("X")) {
//                    turn = "O";
//                }
//                else {
//                    turn = "X";
//                }
// 
//                printBoard();
//                winner = checkWinner();
//            }
//            else {
//                System.out.println(
//                    "Slot already taken; re-enter slot number:");
//            }
//        }
//       
//        // If no one win or lose from both player x and O.
//        // then here is the logic to print "draw".
//        if (winner.equalsIgnoreCase("draw")) {
//            System.out.println(
//                "It's a draw! Thanks for playing.");
//        }
//       
//        // For winner -to display Congratulations! message.
//        else {
//            System.out.println(
//                "Congratulations! " + winner
//                + "'s have won! Thanks for playing.");
//        }
//      in.close();
    }
		
	public static void displayMenu(Scanner in) {

		System.out.println("Welcome to 3x3 Tic Tac Toe game.");
		System.out.println("");
		System.out.println("1- Enter a player information");
		System.out.println("2- Play");
		System.out.println("3- Display the name of the top winner(s)");
		System.out.println("4- Who are the last three people who won the game in order");
		System.out.println("5- Who are the last three people who lost the game");
		System.out.println("Please enter a number for the action you want to do: ");

		int userInput = in.nextInt();
		System.out.println(userInput);
		
		switch (userInput) {
	        case 1:
	        	enterPlayerInfo();
	            break;
	        case 2:
	            playGame();
	            break;
	        case 3:
	            displayTopWinners();
	            break;
	        case 4:
	            displayLastThreeWinners();
	            break;
	        case 5:
	            displayLastThreeLoosers();
	            break;
		}
        
	}
	
	public static void enterPlayerInfo() {
		Scanner in = new Scanner(System.in);
		
		Queue<String> pl1 = new LinkedList<String>();
		System.out.println("Please enter first player name:");
		String player1 = in.nextLine();
		pl1.add(player1);
		
		Queue<String> pl2 = new LinkedList<String>();
		System.out.println("Please enter second player name:");
		String player2 = in.next();
		pl2.add(player2);
		
		// go back to menu
		displayMenu(in);
	}
	
	public static void displayLastThreeLoosers() {
		System.out.println("displayLastThreeLoosers");
	}

	public static void displayLastThreeWinners() {
		System.out.println("displayLastThreeWinners");
	}
	
	public static void displayTopWinners() {
		System.out.println("displayTopWinners");
	}
	
	public static void playGame() {
		System.out.println("playing");
	}
	
	public static void printBoard() {
		System.out.println("board:");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|---|---|---|");
	}
	
	
	static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String line = null;
 
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }
             
            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }
         
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }
 
       // To enter the X Or O at the exact place on board.
        System.out.println(
            turn + "'s turn; enter a slot number to place "
            + turn + " in:");
        return null;
    }
}
