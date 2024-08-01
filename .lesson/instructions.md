# Data Structure Clue Program
## Detective Jill + Assistant Jack, Clue simulation



***Dr. Foo has been murdered!*** Detective Jill must determine the murderer, crime scene, and weapon. There are six possible murders (numbered 1 through 6, Professor Plum to Mrs. Peacock), 10 locations (1 through 10, ballroom to cellar), and six weapons (1 through 6, lead pipe to spanner). Detective Jill tries to guess the correct combination. Each guess is a theory. She asks her assistant, Jack, to confirm or refute each theory.

Use the files found in this repository to test your answer.  Inside you will find:

 - Model classes (represent the pure data/actions):
	 - `Theory.java` = encapsulates murdered, crime scene, and weapon data
	 - `TheoryItem.java` = convenient methods/constants for translating integers
	 - `AssistantJack.java` = instantiated with answer set, contains method to check your set of guesses (theory)
		 - Answer set 1 = 1, 1, 1
		 - Answer set 2 = 6, 10, 6
		 - Answer set 3 (or any other integer) = randomly chosen theory
 - Driver class (one example of a solution to problem below):
	 - `RandomClue.java` = Driver that tests theory with a simple strategy: use random guesses for each

Note that Assistant Jack will randomly tell you which of your guesses are wrong, if multiple are wrong.  So if you ask Assistant Jack to check your answer with the same set of guesses, you may get a different item that is wrong which means that both the first and second items returned are wrong.  When checking guesses with Assistant Jack, your number of guesses (times you ask to check the potential answer) is kept track of.  Your goal is to write a program as if you were Detective Jill which **consistently** finds the solution in <= 20 checks for any of the three answer sets above, that means you didn't just get lucky!

For example, the provided `RandomClue.java` is a driver that randomly guesses each weapon, location, and person, until the correct solution is found.  Run the program a couple of times for each theory (1, 2, 3) and answer the following questions:
 - How often do you get a solution in fewer than 20 guesses?  Does this change depending on the theory you test (1, 2, 3)?
 - What is good or bad about this strategy?

**Answer the above questions for your implementation as well.** Place all answers in a .txt file in the `Files` package.

