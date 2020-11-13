import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        System.out.println("Hello meager carbon-based life form, " +
                "wanna play Rock-Paper-Scissors?");
        // Allows player to pick number of rounds.
        System.out.println("Enter the number of rounds you'd like to play: ");
        Scanner rounds = new Scanner(System.in);
        int numOfRounds = rounds.nextInt();
        // Creates an object of Game, then starts the game.
        Game rps = new Game(numOfRounds);

        rps.playGame();
    }
}