import java.util.Scanner;

public class TextAdventureGame {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean hasKey = false;
    private static boolean hasSword = false;
    private static boolean hasPotion = false;

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("You find yourself in a dark forest...");

        // Stage 1: Exploring the Forest
        exploreForest();
    }

    private static void exploreForest() {
        System.out.println("You are exploring the forest...");
        System.out.println("You encounter a fork in the road...");
        System.out.println("What do you do?");
        System.out.println("1. Go left");
        System.out.println("2. Go right");

        int choice = getUserChoice(1, 2);

        if (choice == 1) {
            System.out.println("You chose to go left...");
            System.out.println("You stumble upon a hidden treasure chest!");

            System.out.println("Do you want to open it?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            choice = getUserChoice(1, 2);

            if (choice == 1) {
                System.out.println("You open the chest and find a shiny key!");
                System.out.println("You pick up the key.");
                hasKey = true;
                System.out.println("Your journey continues...");
                // Now, we can proceed to the next stage
                exploreCave();
            } else {
                System.out.println("You decide not to open the chest and continue your journey.");
                System.out.println("Your journey continues...");
                // Now, we can proceed to the next stage
                exploreCave();
            }
        } else {
            System.out.println("You chose to go right...");
            System.out.println("You walk for a while and suddenly encounter a wild bear!");

            System.out.println("What do you do?");
            System.out.println("1. Try to run away");
            System.out.println("2. Play dead");
            System.out.println("3. Fight the bear");

            choice = getUserChoice(1, 3);

            if (choice == 1) {
                System.out.println("You try to run away, but the bear catches up and you get injured.");
                System.out.println("Game over!");
            } else if (choice == 2) {
                System.out.println("You play dead and the bear loses interest.");
                System.out.println("You manage to escape safely.");
                System.out.println("Congratulations! You survived!");
            } else {
                System.out.println("You decide to fight the bear...");

                // Generate a random number to determine the outcome of the fight
                int randomNumber = (int) (Math.random() * 10) + 1;
                if (randomNumber <= 3) {
                    System.out.println("You bravely fight the bear and defeat it!");
                    System.out.println("You emerge victorious!");
                    System.out.println("Congratulations! You win!");
                } else {
                    System.out.println("The bear is too strong and overwhelms you.");
                    System.out.println("Game over!");
                }
            }
        }
    }

    private static void exploreCave() {
        System.out.println("You enter the cave and find yourself in a dimly lit chamber.");
        System.out.println("There are three tunnels leading deeper into the cave.");

        System.out.println("Which tunnel do you choose?");
        System.out.println("1. Left tunnel");
        System.out.println("2. Middle tunnel");
        System.out.println("3. Right tunnel");

        int choice = getUserChoice(1, 3);

        switch (choice) {
            case 1:
                System.out.println("You enter the left tunnel and find a stash of healing potions!");
                System.out.println("You take the potions and feel reinvigorated.");
                hasPotion = true;
                System.out.println("Your journey continues...");
                // Proceed to the next stage
                encounterDragon();
                break;
            case 2:
                System.out.println("You enter the middle tunnel and encounter a giant spider!");
                System.out.println("What do you do?");
                System.out.println("1. Fight the spider");
                System.out.println("2. Run away");

                int spiderChoice = getUserChoice(1, 2);

                if (spiderChoice == 1) {
                    System.out.println("You bravely fight the spider and emerge victorious!");
                    System.out.println("You continue exploring the cave...");
                    // Proceed to the next stage
                    findSword();
                } else {
                    System.out.println("You try to run away, but the spider catches up and bites you.");
                    System.out.println("Game over!");
                }
                break;
            case 3:
                System.out.println("You enter the right tunnel and find a hidden chamber.");
                System.out.println("Inside the chamber, you discover a valuable treasure!");
                System.out.println("Congratulations! You win!");
                break;
        }
    }

    private static void encounterDragon() {
        System.out.println("As you venture deeper into the cave, you encounter a mighty dragon!");
        System.out.println("What do you do?");
        System.out.println("1. Try to negotiate with the dragon");
        System.out.println("2. Fight the dragon");

        int choice = getUserChoice(1, 2);

        if (choice == 1) {
            System.out.println("You attempt to negotiate with the dragon...");
            System.out.println("The dragon agrees to let you pass, impressed by your courage.");
            System.out.println("You continue your journey...");
            // Proceed to the next stage
            findSword();
        } else {
            System.out.println("You decide to fight the dragon...");

            // Generate a random number to determine the outcome of the fight
            int randomNumber = (int) (Math.random() * 10) + 1;
            if (randomNumber <= 5) {
                System.out.println("You engage in a fierce battle with the dragon and emerge victorious!");
                System.out.println("Congratulations! You defeat the dragon!");
                System.out.println("Your journey continues...");
                // Proceed to the next stage
                findSword();
            } else {
                System.out.println("The dragon unleashes its fiery breath upon you...");
                System.out.println("Game over!");
            }
        }
    }

    private static void findSword() {
        System.out.println("As you explore further, you find an ancient sword lodged in a stone.");
        System.out.println("Do you want to try and pull the sword?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = getUserChoice(1, 2);

        if (choice == 1) {
            System.out.println("You muster all your strength and pull the sword from the stone!");
            System.out.println("Congratulations! You now wield a powerful weapon.");
            hasSword = true;
            System.out.println("Your journey continues...");
            // Proceed to the next stage
            finalStage();
        } else {
            System.out.println("You decide not to attempt pulling the sword and continue your journey.");
            System.out.println("Your journey continues...");
            // Proceed to the next stage
            finalStage();
        }
    }

    private static void finalStage() {
        System.out.println("You have reached the final stage of your adventure!");
        System.out.println("You find yourself in front of a massive castle.");

        if (hasSword && hasPotion) {
            System.out.println("With your sword and potions, you feel ready to face any challenge.");
            System.out.println("Do you want to storm the castle and confront its mysterious ruler?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int choice = getUserChoice(1, 2);

            if (choice == 1) {
                System.out.println("You bravely charge into the castle, prepared for whatever lies ahead...");
                System.out.println("Congratulations! You have completed the adventure and emerged victorious!");
            } else {
                System.out.println("You decide to retreat and continue your journey elsewhere.");
                System.out.println("Your adventure ends here.");
            }
        } else {
            System.out.println("You feel unprepared to face the challenges within the castle.");
            System.out.println("You decide to explore further and prepare yourself for the final confrontation.");
            System.out.println("Your adventure continues...");
        }
    }

    private static int getUserChoice(int minChoice, int maxChoice) {
        int choice;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= minChoice && choice <= maxChoice) {
                    break;
                } else {
                    System.out.println("Invalid choice! Please enter a number between " + minChoice + " and " + maxChoice);
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return choice;
    }
}
