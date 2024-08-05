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
        int answerSet = random.nextInt(3) + 1; // ! ensure we get 1, 2, or random (3)
        this.jack = new AssistantJack(answerSet); // ! use parameterized constructor
    }

    public void initializeTheoryGeneration() {
        // ! method to initialize theory generation
        this.solutionWeapon = 1;
        this.solutionLocation = 1;
        this.solutionPerson = 1;
    }

    public void generateTheories() {
        boolean solved = false;
        while (!solved) {
            Theory theory = new Theory(solutionWeapon, solutionLocation, solutionPerson); // ! create new theory
            int result = jack.checkAnswer(theory); // ! check theory with AssistantJack
            System.out.println("Checking theory: Weapon " + solutionWeapon + ", Location " + solutionLocation + ", Person " + solutionPerson); // ! debug statement
            System.out.println("Result: " + result); // ! debug statement
            if (result == 0) {
                // ! correct theory found
                solved = true;
            } else {
                adjustTheory(result); // ! adjust the theory based on the feedback
            }
        }
    }

    private void adjustTheory(int result) {
        switch (result) {
            case 1:
                solutionWeapon = (solutionWeapon % 6) + 1; // ! adjust weapon
                break;
            case 2:
                solutionLocation = (solutionLocation % 10) + 1; // ! adjust location
                break;
            case 3:
                solutionPerson = (solutionPerson % 6) + 1; // ! adjust person
                break;
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
