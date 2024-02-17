package loops;
import java.util.Scanner;
import java.util.Random;

/*
* Challenge: Travel game board of 20 spaces within 5 die rolls.
* After each roll, tell player which space they are on and how far left they have to go to win.
* Rolls are automatic
* If player reaches exactly 20 before the game ends, they win. Else they lose. Advise them of game outcome.
 */

public class DiceGame {
    public static void main(String[] args){

        // Initialise known variables
        int boardSpaces = 20;
        int maxRolls = 5;
        Random random = new Random(); // Initialise random utility
        //int dieRoll = random.nextInt(6)+1; // Hold variable for current roll

        // Initialise Dynamic variables
        int currentSpace = 0;
        int remainingSpaces = 20 - currentSpace;
        boolean victory = false;
        boolean keepTrying = true;

        System.out.println("The game begins.");
        while(currentSpace != boardSpaces && keepTrying == true){

            for(int i=0; i<maxRolls; i++){
                int dieRoll = random.nextInt(6)+1; // Hold variable for current roll
                int currentSpaceProtected = currentSpace;
                currentSpace = currentSpace + dieRoll;
                int remainingSpacesProtected = remainingSpaces;
                remainingSpaces = 20 - currentSpaceProtected;

                if(currentSpace == 20){
                    System.out.println("Roll #" + (i+1) + ": You rolled a " + dieRoll +
                            ". You are in " + currentSpace + ". With " + remainingSpaces + " to the end. You Win.");
                    victory = true;
                    keepTrying = false;
                    break;
                }else if(currentSpace > 20){
                    currentSpace = currentSpaceProtected;
                    System.out.println("Roll #" + (i+1) + ": You rolled a " + dieRoll +
                            ". You are in " + currentSpaceProtected + ". With " + remainingSpacesProtected + " to the end. Exact roll required");
                } else if(i == 4){
                    System.out.println("Roll #" + (i+1) + ": You rolled a " + dieRoll +
                            ". You are in " + currentSpace + ". With " + remainingSpaces + " to the end. No more turns - You lose");
                    keepTrying = false;
                    break;

                }else
                System.out.println("Roll #" + (i+1) + ": You rolled a " + dieRoll +
                        ". You are in " + currentSpace + ". With " + remainingSpaces + " to the end.");
            }

        }
        if(victory == false){
            System.out.println("You lose");
        }else{
            System.out.println("You win");
        }

    }
}
