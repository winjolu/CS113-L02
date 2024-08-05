import java.util.ArrayList;
import java.util.Scanner;

public class DetectiveJill {

    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, solution = -1, weapon = 1, location = 1, person = 1;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);

        // INPUT
        System.out.print("Which theory would you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();

        // PROCESSING
        jack = new AssistantJack(answerSet);

        // Attempt to solve the mystery within a set number of guesses
        int attempts = 0;
        while (attempts < 20) {
            // Check the theory with AssistantJack
            solution = jack.checkAnswer(weapon, location, person);

            // Print the result
            if (solution == 0) {
                System.out.println("Correct theory found: Weapon=" + weapon + ", Location=" + location + ", Person=" + person);
                break;
            } else if (solution == 1) {
                weapon++;
                if (weapon > 6) {
                    weapon = 1;
                }
            } else if (solution == 2) {
                location++;
                if (location > 10) {
                    location = 1;
                }
            } else if (solution == 3) {
                person++;
                if (person > 6) {
                    person = 1;
                }
            }

            attempts++;
        }

        if (solution != 0) {
            System.out.println("Failed to find the correct theory in 20 attempts.");
        }

        // Close the scanner
        keyboard.close();
    }
}
