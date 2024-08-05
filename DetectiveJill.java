// have some thought on how to refactor this thing. 


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DetectiveJill {

    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, solution = -1, weapon, location, person;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> weaponList = new ArrayList<>();
        ArrayList<Integer> locationList = new ArrayList<>();
        ArrayList<Integer> personList = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            weaponList.add(i);
        }

        for (int i = 1; i <= 10; i++) {
            locationList.add(i);
        }    

        for (int i = 1; i <= 6; i++) {
            personList.add(i);
        } 

        System.out.println("Weapon List: " + weaponList);
        System.out.println("Location List: " + locationList);
        System.out.println("Person List: " + personList);

        // INPUT
        System.out.print("Which theory would you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();

        // PROCESSING
        jack = new AssistantJack(answerSet);

        // Attempt to solve the mystery within a set number of guesses
        int attempts = 0;
        while (attempts < 20) {
            // Generate a new random theory from the remaining lists
            Random random = new Random();
            weapon = weaponList.get(random.nextInt(weaponList.size()));
            location = locationList.get(random.nextInt(locationList.size()));
            person = personList.get(random.nextInt(personList.size()));

            // Check the theory with AssistantJack
            solution = jack.checkAnswer(weapon, location, person);

            // Print the result
            if (solution == 0) {
                System.out.println("Correct theory found: Weapon=" + weapon + ", Location=" + location + ", Person=" + person);
                System.out.println("Number of attempts: " + (attempts + 1));
                break;
            } else if (solution == 1) {
                weaponList.remove(Integer.valueOf(weapon));
            } else if (solution == 2) {
                locationList.remove(Integer.valueOf(location));
            } else if (solution == 3) {
                personList.remove(Integer.valueOf(person));
            }

            attempts++;
        }

        if (solution != 0) {
            System.out.println("Failed to find the correct theory in 20 attempts.");
            System.out.println("Number of attempts: " + attempts);
        }

        // Close the scanner
        keyboard.close();

        // Print the remaining lists
        System.out.println("Remaining Weapon List: " + weaponList);
        System.out.println("Remaining Location List: " + locationList);
        System.out.println("Remaining Person List: " + personList);
    }
}
