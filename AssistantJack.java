import java.util.ArrayList;
import java.util.Random;

public class AssistantJack {

    private int timesAsked;
    private Theory correctTheory;

    /**
     * The default constructor but will not be called from outside.
     */
    private AssistantJack() {
        this.timesAsked = 0;
        this.correctTheory = null;
    }

    /**
     * The full constructor, specifying which assistant to use (answer set 1,
     * answer set 2, or random). Depending on assistant, a different correct
     * Theory object is created.
     *
     * @param answerSet 1 is a fixed answer of 1,1,1 and 2 is a fixed answer of 6,10,6
     *                  any other integer will be randomly assigned
     */
    public AssistantJack(int answerSet) { // ! reintroduced parameterized constructor
        this();

        if (answerSet == 1) {
            this.correctTheory = new Theory(1, 1, 1);
        } else if (answerSet == 2) {
            this.correctTheory = new Theory(6, 10, 6);
        } else {
            Random random = new Random();
            int weapon = random.nextInt(6) + 1; // ! ensure variability
            int location = random.nextInt(10) + 1; // ! ensure variability
            int person = random.nextInt(6) + 1; // ! ensure variability
            this.correctTheory = new Theory(weapon, location, person);
        }
        System.out.println("Correct Theory: Weapon " + correctTheory.getWeapon() + ", Location " + correctTheory.getLocation() + ", Person " + correctTheory.getPerson()); // ! debug statement
    }

    /**
     * Creates an assistant Jack with a theory that was passed in.
     *
     * @param theory deep copied object stored as correct theory
     */
    public AssistantJack(Theory theory) {
        this();
        this.correctTheory = new Theory(theory);
    }

    /**
     * Will report to the user whether their theory is correct. It will return a
     * number that needs to be interpreted (see return). Also keeps track of
     * times asked by incrementing every time this method is called
     *
     * @param weapon the weapon used 1 - 6
     * @param location the location where it was done 1 - 10
     * @param person the person who did it 1 - 6
     * @return 0 if all three are correct, 1 if the weapon is incorrect, 2 if
     * the location is incorrect and 3 if the person is incorrect. If
     * multiple are incorrect it will randomly select one of the
     * incorrect parts and return that.
     */
    public int checkAnswer(int weapon, int location, int person) {
        ArrayList<Integer> wrongItems = new ArrayList<>();

        this.timesAsked++;

        // check each part and add to array list appropriately
        if (this.correctTheory.getWeapon() != weapon) {
            wrongItems.add(1);
        }

        if (this.correctTheory.getLocation() != location) {
            wrongItems.add(2);
        }

        if (this.correctTheory.getPerson() != person) {
            wrongItems.add(3);
        }

        // return based on incorrect items, if any, in array list
        if (wrongItems.size() == 0) {
            return 0;
        } else if (wrongItems.size() == 1) {
            return wrongItems.get(0);
        } else {
            Random random = new Random();
            int randomSelected = random.nextInt(wrongItems.size());
            return wrongItems.get(randomSelected);
        }
    }

    /**
     * Pass through (convenient) method that converts the theory to numbers and
     * sends it to the overloaded method.
     *
     * @param theory a theory of the murder, weapon and location
     * @return 0 if all three are correct, 1 if the weapon is incorrect, 2 if
     * the location is incorrect and 3 if the person is incorrect. If
     * multiple are incorrect it will randomly select one of the
     * incorrect parts and return that.
     */
    public int checkAnswer(Theory theory) {
        return this.checkAnswer(theory.getWeapon(), theory.getLocation(), theory.getPerson());
    }

    /**
     * Accessor for times your AssistantJack has been asked to check a theory
     *
     * @return number of times AssistantJack has checkAnswer() been called
     */
    public int getTimesAsked() {
        return this.timesAsked;
    }
}
