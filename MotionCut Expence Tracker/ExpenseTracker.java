import java.io.*;
import java.util.*;

public class ExpenseTracker {
    private List<User> users;
    private List<Expense> expenses;

    public ExpenseTracker() {
        users = new ArrayList<>();
        expenses = new ArrayList<>();
        loadDataFromFile();
    }

    public void createAccount(String username, String password) {
        User newUser = new User(username, password);
        users.add(newUser);
        System.out.println("Account created successfully.");
    }

    public void addExpense(String date, String category, double amount) {
        Expense newExpense = new Expense(date, category, amount);
        expenses.add(newExpense);
        System.out.println("Expense added successfully.");
    }

    public void displayExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to display.");
        } else {
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    public void calculateCategorySum() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to calculate.");
        } else {
            Map<String, Double> categorySumMap = new HashMap<>();
            for (Expense expense : expenses) {
                String category = expense.getCategory();
                double amount = expense.getAmount();
                categorySumMap.put(category, categorySumMap.getOrDefault(category, 0.0) + amount);
            }
            System.out.println("Category-wise Summation:");
            for (Map.Entry<String, Double> entry : categorySumMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public void saveDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("expenses.dat"))) {
            oos.writeObject(users);
            oos.writeObject(expenses);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadDataFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("expenses.dat"))) {
            users = (List<User>) ois.readObject();
            expenses = (List<Expense>) ois.readObject();
            System.out.println("Data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("Data file not found. Starting with empty data.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseTracker expenseTracker = new ExpenseTracker();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Add Expense");
            System.out.println("3. Display Expenses");
            System.out.println("4. Calculate Category-wise Summation");
            System.out.println("5. Save Data to File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    expenseTracker.createAccount(username, password);
                    break;
                case 2:
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    expenseTracker.addExpense(date, category, amount);
                    break;
                case 3:
                    expenseTracker.displayExpenses();
                    break;
                case 4:
                    expenseTracker.calculateCategorySum();
                    break;
                case 5:
                    expenseTracker.saveDataToFile();
                    break;
                case 6:
                    expenseTracker.saveDataToFile();
                    exit = true;
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}

class User implements Serializable {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
}

class Expense implements Serializable {
    private String date;
    private String category;
    private double amount;

    public Expense(String date, String category, double amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Category: " + category + ", Amount: " + amount;
    }
}
