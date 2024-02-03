import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        displayWelcomeScreen();

        Quiz quiz = createQuiz();
        Scanner scanner = new Scanner(System.in);

        int userScore = 0;

        for (int i = 0; i < quiz.size(); i++) {
            Question currentQuestion = quiz.getQuestion(i);

            System.out.println("\n" + currentQuestion.getQuestionText());
            String[] options = currentQuestion.getOptions();
            displayOptions(options);

            int userAnswer = getUserInput(scanner, 1, options.length);

            if (userAnswer - 1 == currentQuestion.getCorrectAnswerIndex()) {
                System.out.println("Correct! 🎉");
                userScore++;
            } else {
                System.out.println("Oops! The correct answer is: " + (currentQuestion.getCorrectAnswerIndex() + 1) + " 😕");
            }
        }

        displayFinalScore(userScore, quiz.size());

        scanner.close();
    }

    private static void displayWelcomeScreen() {
        System.out.println("***********************************");
        System.out.println("   Welcome to the Online Quiz App   ");
        System.out.println("***********************************\n");
        System.out.println("Get ready for an exciting quiz adventure!\n");
    }

    private static Quiz createQuiz() {
        Quiz quiz = new Quiz();
        quiz.addQuestion(new Question("Que.  1) Which country is known as the 'Land of the Rising Sun'?",
                new String[]{"China", "Japan", "South Korea", "India"}, 1));
        quiz.addQuestion(new Question("Que.  2) What is the currency of the United Kingdom?",
                new String[]{"Dollar", "Euro", "Pound", "Yen"}, 2));
        quiz.addQuestion(new Question("Que.  3) Who wrote 'Romeo and Juliet'?",
                new String[]{"Charles Dickens", "William Shakespeare", "Jane Austen", "Emily Bronte"}, 1));
        quiz.addQuestion(new Question("Que.  4) Which ocean is the largest on Earth?",
                new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, 3));
        quiz.addQuestion(new Question("Que.  5) In which year did World War II end?",
                new String[]{"1942", "1945", "1950", "1939"}, 1));
        quiz.addQuestion(new Question("Que.  6) What is the capital of Brazil?",
                new String[]{"Buenos Aires", "Brasília", "Rio de Janeiro", "Sao Paulo"}, 1));
        quiz.addQuestion(new Question("Que.  7) Which element has the chemical symbol 'O'?",
                new String[]{"Oxygen", "Osmium", "Gold", "Iron"}, 0));
        quiz.addQuestion(new Question("Que.  8) Who is known as the 'Father of Computer Science'?",
                new String[]{"Alan Turing", "Charles Babbage", "Ada Lovelace", "Bill Gates"}, 0));
        quiz.addQuestion(new Question("Que.  9) What is the largest mammal on Earth?",
                new String[]{"Elephant", "Blue Whale", "Giraffe", "Hippopotamus"}, 1));
        quiz.addQuestion(new Question("Que. 10) Which planet is known as the 'Red Planet'?",
                new String[]{"Mars", "Venus", "Jupiter", "Saturn"}, 0));

        return quiz;
    }

    private static void displayOptions(String[] options) {
        for (int j = 0; j < options.length; j++) {
            System.out.println((j + 1) + ". " + options[j]);
        }
    }

    private static int getUserInput(Scanner scanner, int min, int max) {
        int userInput = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter your choice (1-" + max + "): ");
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                if (userInput >= min && userInput <= max) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        return userInput;
    }

    private static void displayFinalScore(int userScore, int totalQuestions) {
        System.out.println("\n***********************************");
        System.out.println("            Quiz Completed!         ");
        System.out.println("***********************************\n");

        System.out.println("Your final score: " + userScore + "/" + totalQuestions);

        if (userScore == totalQuestions) {
            System.out.println("Congratulations! You got a perfect score. 🌟");
        } else if (userScore >= totalQuestions / 2) {
            System.out.println("Well done! You did great. 👏");
        } else {
            System.out.println("Keep practicing. You can do better next time. 💪");
        }
    }
}

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

class Quiz {
    private List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public int size() {
        return questions.size();
    }
}
