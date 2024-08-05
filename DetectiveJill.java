import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DetectiveJill {

    private AssistantJack jack;
    private int solutionWeapon;
    private int solutionLocation;
    private int solutionPerson;

    public DetectiveJill() {
        Random random = new Random();
        int answerSet = random.nextInt(3); // ! generate a random answer set (0, 1, or 2)
        this.jack = new AssistantJack(answerSet); // ! initialize AssistantJack with the random answer set
    }

    public void initializeTheoryGeneration() {
        // ! method to initialize theory generation
        this.solutionWeapon = 1;
        this.solutionLocation = 1;
        this.solutionPerson = 1;
    }

    public void generateTheories() {
        /* ! iterate through all possible combinations of weapon, location, and person */
        for (int weapon = 1; weapon <= 6; weapon++) { // ! 6 possible weapons
            for (int location = 1; location <= 10; location++) { // ! 10 possible locations
                for (int person = 1; person <= 6; person++) { // ! 6 possible persons
                    Theory theory = new Theory(weapon, location, person); // ! create new theory
                    int result = jack.checkAnswer(theory); // ! check theory with AssistantJack
                    System.out.println("Checking theory: Weapon " + weapon + ", Location " + location + ", Person " + person); // ! debug statement
                    System.out.println("Result: " + result); // ! debug statement
                    if (result == 0) {
                        // ! correct theory found
                        this.solutionWeapon = weapon;
                        this.solutionLocation = location;
                        this.solutionPerson = person;
                        return; // ! exit method as we found the correct theory
                    }
                }
            }
        }
    }

    public static void main(String[] args) { // !
        DetectiveJill detective = new DetectiveJill(); // !
        detective.initializeTheoryGeneration(); // !
        detective.generateTheories(); // !
        System.out.println("Theory generation completed."); // !
        System.out.println("Solution found: Weapon " + detective.solutionWeapon + // !
                           ", Location " + detective.solutionLocation + // !
                           ", Person " + detective.solutionPerson); // !
    }
}
