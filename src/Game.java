import java.util.Scanner;

public class Game {
    Player players[];
    private final int NUM_OF_ROUNDS;

    public Game(int numOfRounds){
        // Sets the num of rounds.
        NUM_OF_ROUNDS = numOfRounds;
    }

    public void openGame(){
        // Scanner to grab the name of the player.
        Scanner name = new Scanner(System.in);
        players = new Player[2];

        System.out.println("Please enter your player's name: ");
        String p1Name = name.next();
        System.out.println("Welcome to the end of your existence, " + p1Name);

        System.out.println("My name is Chad, loser.");
        String computerName = "Chad";

        players[0] = new Player(p1Name);
        players[1] = new Player(computerName);

        System.out.println("To play this game enter 'R' for Rock, 'P' for Paper, or 'S' for Scissors!");
    }

    public void playGame(){
        // Opens the game first.
        openGame();

        // Game loop
        for(int i = 0; i < NUM_OF_ROUNDS; i++){
            playRound();
        }

        // At the end of the game, decide who wins.
        determineWinner();
    }

    public void playRound(){
        // Get the moves of each.
        String p1Move = players[0].shootHuman();
        String computerMove = players[1].shootComputer();

        // Says what each move is
        System.out.println(players[0].NAME + " shoots " + p1Move);
        System.out.println(players[1].NAME + " shoots " + computerMove);

        // Determines who wins the round.

        // If statement to determine if the human player wins.
        if((p1Move.equals("ROCK") && computerMove.equals("SCISSORS")) || (p1Move.equals("PAPER") && computerMove.equals("ROCK")) || (p1Move.equals("SCISSORS") && computerMove.equals("PAPER"))){
            // P1 wins this round, add to their score.
            players[0].incrementScore();

            // Print winner and current scores.
            System.out.println("\n" + players[0].NAME + " has won this round!");
            System.out.println("Current Standings:");
            System.out.println(players[0].NAME + ": " + players[0].getScore() + " | " + players[1].NAME + ": " + players[1].getScore());

        // Else if to determine if the NPC wins this round.
        }else if((computerMove.equals("ROCK") && p1Move.equals("SCISSORS")) || (computerMove.equals("PAPER") && p1Move.equals("ROCK")) || (computerMove.equals("SCISSORS") && p1Move.equals("PAPER"))){
            // Computer wins the round, add to their score.
            players[1].incrementScore();

            // Print winner and current scores.
            System.out.println("\n" + players[1].NAME + " has won this round!");
            System.out.println("Current Standings:");
            System.out.println(players[0].NAME + ": " + players[0].getScore() + " | " + players[1].NAME + ": " + players[1].getScore());

            // Cheeky reply
            players[1].cheekyDialogue("roundWin");
        }else{
            // Neither player wins, it is a tie.
            System.out.println("Neither play has won this round, it is a tie!");
            System.out.println("\nCurrent Standings:");
            System.out.println(players[0].NAME + ": " + players[0].getScore() + " | " + players[1].NAME + ": " + players[1].getScore());
        }
    }

    public void determineWinner(){
        // Determines who wins the game overall.

        if(players[0].getScore() > players[1].getScore()){
            // Player 1 wins the game.
            System.out.println(players[0].NAME + " has won the game with " + players[0].getScore() + " points!");
            players[1].cheekyDialogue("anyLoss");

        }else if(players[1].getScore() > players[0].getScore()){
            // NPC wins the game.
            System.out.println(players[1].NAME + " has won the game with " + players[1].getScore() + " points!");
            players[1].cheekyDialogue("gameWin");

        }else{
            // Nobody wins, it is a tie.
            System.out.println("Nobody has won!  It is a tie!");
        }

    }
}