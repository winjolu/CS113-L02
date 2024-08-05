
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DetectiveJill {

    public static void main() {
        // DECLARATION + INITIALIZATION
        int answerSet, solution, murder, weapon, location;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> weaponList = new ArrayList<>();
        ArrayList<Integer> locationList = new ArrayList<>();
        ArrayList<Integer> murderList = new ArrayList<>();

        for (int i = 1; i <=16; i++) {
          weaponList.add(i);
        }

        for (int i = 1; i <=10; i++) {
          locationList.add(i);
        }    

        for (int i = 1; i <=6; i++) {
          murderList.add(i);
        } 

        System.out.println(weaponList);
        System.out.println(locationList);
        System.out.println(murderList);


        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        //PROCESSING
        jack = new AssistantJack(answerSet);

        solution = jack.checkAnswer(weaponList.get(0), locationList.get(0), murderList.get(0));
        System.out.println(solution);
    }
}
