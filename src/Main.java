import java.util.*;

public class Main {

	static String[] board;
    static String turn;
    static String player1Name;
    static String player2Name;

    
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
                return player1Name;
            }
             
            // For O winner
            else if (line.equals("OOO")) {
                return player2Name;
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
     
 
    public static void main(String[] args) {
        displayMenu();
    } 
    
		
	public static void displayMenu() {
		Scanner in = new Scanner(System.in);

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
		
		
		Queue<String> queue1 = new LinkedList<String>();
		
		System.out.println("Please enter first player name:");
		String plName1 = in.nextLine();
		
		System.out.println("Please enter first player age:");
		int player1Age = in.nextInt();

		Player pl1 = new Player(plName1, player1Age);
		player1Name = pl1.getName();
		queue1.add(player1Name);
        in.nextLine();

		
		Queue<String> queue2 = new LinkedList<String>();
		
		System.out.println("Please enter second player name:");
		String plName2 = in.nextLine();
		
		System.out.println("Please enter second player age:");
		int player2Age = in.nextInt();

		Player pl2 = new Player(plName2, player2Age);
		player2Name = pl2.getName();
		queue2.add(player2Name);
        in.nextLine();

	
//		in.close();
		// go back to menu
		displayMenu();
	}
	
	public static void playGame() {
		Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;
 
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
 
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        
        printBoard();
 
		System.out.println(
				player1Name + " will play first. Enter a slot number to place X in:");
 
        while (winner == null) {
            int numInput;
           
           
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                        "Invalid input; re-enter slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                    "Invalid input; re-enter slot number:");
                in.nextLine();
                continue;
            }
             
            
            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;
 
                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }
 
                printBoard();
                winner = checkWinner();
            }
            else {
                System.out.println(
                    "Slot already taken; re-enter slot number:");
            }
        }
       
        // If no one win or lose from both player x and O.
        // then here is the logic to print "draw".
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                "It's a draw! Thanks for playing.");
        }
       
        // For winner -to display Congratulations! message.
        else {
            System.out.println(
                "Congratulations! " + winner
                + " have won! Thanks for playing.");
        }
      in.close();

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

}
