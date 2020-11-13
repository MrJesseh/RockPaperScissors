import java.util.Scanner;

public class Player {
    public final String NAME;
    private int score;

    public Player(String name){
        // Constructor for the player
        NAME = name;
    }

    public String shootHuman(){
        // Scans for the player's input of symbol.
        Scanner hand = new Scanner(System.in);

        System.out.println("Enter 'R' for Rock, 'P' for Paper, or 'S' for Scissors!");
        String moveInput = hand.next();
        String move = "";
        if (moveInput.equals("R") || moveInput.equals("r")){
            move = "ROCK";
        }else if(moveInput.equals("P") || moveInput.equals("p")){
            move = "PAPER";
        }else if(moveInput.equals("S") || moveInput.equals("s")){
            move = "SCISSORS";
        }
        return move;
    }

    public String shootComputer(){
        // Put moves in an array to access them easier.
        String[] moves = {"ROCK", "PAPER", "SCISSORS"};

        // Random number to get the computer's move.
        int computerMove = (int)(Math.random() * moves.length);

        return(moves[computerMove]);
    }

    public void incrementScore(){
        // Method to increment the score for each player.
        score++;
    }

    public int getScore(){
        // Returns the player's score.
        return score;
    }

    public void cheekyDialogue(String type) {
        // Type determines which type of dialogue is used.  Gives more variety.

        // Round winning dialogue
        if(type.equals("roundWin")) {
            String[] roundDialogue = {
                    "You really think you can beat me, fleshy?",
                    "You're bad lol....",
                    "My processor is far superior to your brain",
                    "Funny how we're playing this game.... and I don't even have hands.",
                    "I could be doing something cool right now... Like calculating every number in pi."
            };
            int randomDialogue = (int) (Math.random() * roundDialogue.length - 1);
            System.out.println("\n" + "Chad: " + roundDialogue[randomDialogue]);
        // Game winning dialogue.
        }else if(type.equals("gameWin")){
            String[] winDialogue = {
                    "That was EZ, you never stood a chance.",
                    "Did you even try?  Come on man...",
                    "HA! You suck!",
                    "You are absolutely terrible, human.",
                    "I'm literally just millions of switches, AND I STILL BEAT YOU!"
            };
            int randomDialogue = (int) (Math.random() * winDialogue.length - 1);
            System.out.println("\n" + "Chad: " + winDialogue[randomDialogue]);
        // Game losing dialogue.
        }else if(type.equals("anyLoss")){
            String[] lossDialogue = {
                    "I can't believe I lost to a mortal...",
                    "Apparently I miscalculated, which almost never happens.",
                    "GG!  You won't get this lucky next time.",
                    "Congrats human, don't get used to this though."
            };
            int randomDialogue = (int) (Math.random() * lossDialogue.length - 1);
            System.out.println("\n" + "Chad: " + lossDialogue[randomDialogue]);
        }
    }
}