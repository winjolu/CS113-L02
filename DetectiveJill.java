import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DetectiveJill {

    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, solution, weapon, location, person;
        Theory theory;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Which theory would you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // initialize AssistantJack with the selected answerSet
        jack = new AssistantJack(answerSet);

        // Extract scenario from Jack if answerSet is 1 or 2
        if (answerSet == 1 || answerSet == 2) {
            theory = jack.getCorrectTheory();
        } else {
            // generate initial theory using Random if answerSet is 3
            Random random = new Random();
            weapon = random.nextInt(6) + 1;
            location = random.nextInt(10) + 1;
            person = random.nextInt(6) + 1;
            theory = new Theory(weapon, location, person);
        }

        // attempt to solve the mystery
        solve(jack);

        // print the solution
        System.out.println("Solution found:");
        System.out.println("Weapon: " + theory.getWeapon());
        System.out.println("Location: " + theory.getLocation());
        System.out.println("Person: " + theory.getPerson());
    }

    /**
     * Attempts to solve the mystery within a set number of guesses.
     * 
     * @param jack the AssistantJack instance to check theories against
     * @return Theory the correct theory once it has been identified
     */
    public static Theory solve(AssistantJack jack) {
        int maxGuesses = 20;
        int attempts = 0;

        ArrayList<Integer> weapons = new ArrayList<>();
        ArrayList<Integer> locations = new ArrayList<>();
        ArrayList<Integer> persons = new ArrayList<>();

        // populate the lists
        for (int i = 1; i <= 6; i++) weapons.add(i);
        for (int i = 1; i <= 10; i++) locations.add(i);
        for (int i = 1; i <= 6; i++) persons.add(i);

        Theory currentTheory = new Theory(weapons.get(0), locations.get(0), persons.get(0));
        int result = -1;

        // Check and isolate weapon
        for (int w : weapons) {
            if (attempts >= maxGuesses) break;
            currentTheory.setWeapon(w);
            result = jack.checkTheory(currentTheory);
            attempts++;
            if (result == 0 || result == 2 || result == 3) break; // correct weapon found
        }

        // Check and isolate location
        for (int l : locations) {
            if (attempts >= maxGuesses) break;
            currentTheory.setLocation(l);
            result = jack.checkTheory(currentTheory);
            attempts++;
            if (result == 0 || result == 1 || result == 3) break; // correct location found
        }

        // Check and isolate person
        for (int p : persons) {
            if (attempts >= maxGuesses) break;
            currentTheory.setPerson(p);
            result = jack.checkTheory(currentTheory);
            attempts++;
            if (result == 0 || result == 1 || result == 2) break; // correct person found
        }

        return currentTheory;
    }
}