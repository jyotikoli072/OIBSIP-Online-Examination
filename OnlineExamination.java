import java.util.HashMap;
import java.util.Scanner;

public class OnlineExamination {
    private static HashMap<String, String> userDatabase = new HashMap<>();
    private static HashMap<String, Integer> userScores = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    private static String currentUser;

    public static void main(String[] args) {
        initializeUsers();

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    if (login()) {
                        mainMenu();
                    }
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Thank you for using the Online Examination System.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeUsers() {
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        userScores.put("user1", 0);
        userScores.put("user2", 0);
    }

    private static boolean login() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            currentUser = username;
            System.out.println("Login successful. Welcome " + username + "!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    private static void register() {
        System.out.print("Enter new username: ");
        String username = sc.nextLine();
        System.out.print("Enter new password: ");
        String password = sc.nextLine();

        if (userDatabase.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
        } else {
            userDatabase.put(username, password);
            userScores.put(username, 0);
            System.out.println("Registration successful. You can now login.");
        }
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("1. Take Exam");
            System.out.println("2. View Marks");
            System.out.println("3. Update Profile");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    takeExam();
                    break;
                case 2:
                    viewMarks();
                    break;
                case 3:
                    updateProfile();
                    break;
                case 4:
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void takeExam() {
        System.out.println("Select programming language:");
        System.out.println("1. Java");
        System.out.println("2. C");
        System.out.println("3. C++");
        System.out.print("Enter your choice: ");
        int sub = sc.nextInt();
        sc.nextLine(); // consume the newline

        int count = 0;
        System.out.println("There are 5 questions in the examination.");
        System.out.println("Each question consists of 4 options. You have to choose the correct answer.");

        if (sub == 1) {
            // Java questions
            count = javaQuestions();
        } else if (sub == 2) {
            // C questions
            count = cQuestions();
        } else if (sub == 3) {
            // C++ questions
            count = cppQuestions();
        } else {
            System.out.println("Invalid subject choice.");
        }

        userScores.put(currentUser, count);
        System.out.println("You scored " + count + " marks out of 5.");
    }

    private static int javaQuestions() {
        int count = 0;
        int choice;

        System.out.println("Q.1. Which of the following is a valid keyword in Java?");
        System.out.println("1. interface");
        System.out.println("2. string");
        System.out.println("3. Float");
        System.out.println("4. unsigned");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 1) {
            count++;
        }

        System.out.println("Q.2. Which method must be implemented by all threads?");
        System.out.println("1. wait()");
        System.out.println("2. start()");
        System.out.println("3. stop()");
        System.out.println("4. run()");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 4) {
            count++;
        }

        System.out.println("Q.3. Which is the correct declaration of an abstract method?");
        System.out.println("1. abstract void method();");
        System.out.println("2. void abstract method();");
        System.out.println("3. abstract void method() {}");
        System.out.println("4. void method() abstract;");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 1) {
            count++;
        }

        System.out.println("Q.4. Which package contains the Random class?");
        System.out.println("1. java.util");
        System.out.println("2. java.lang");
        System.out.println("3. java.io");
        System.out.println("4. java.awt");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 1) {
            count++;
        }

        System.out.println("Q.5. Which of these is not a Java feature?");
        System.out.println("1. Dynamic");
        System.out.println("2. Architecture Neutral");
        System.out.println("3. Use of Pointers");
        System.out.println("4. Object-oriented");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 3) {
            count++;
        }

        return count;
    }

    private static int cQuestions() {
        int count = 0;
        int choice;

        System.out.println("Q.1. Who is known as the father of C language?");
        System.out.println("1. Bjarne Stroustrup");
        System.out.println("2. James Gosling");
        System.out.println("3. Dennis Ritchie");
        System.out.println("4. Anders Hejlsberg");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 3) {
            count++;
        }

        System.out.println("Q.2. Which of the following is a valid C variable name?");
        System.out.println("1. int number;");
        System.out.println("2. float rate;");
        System.out.println("3. int variable_count;");
        System.out.println("4. int $main;");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 3) {
            count++;
        }

        System.out.println("Q.3. Which is the correct syntax to declare a constant in C?");
        System.out.println("1. constant int var = 10;");
        System.out.println("2. int const var = 10;");
        System.out.println("3. int var = const 10;");
        System.out.println("4. const int var = 10;");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 4) {
            count++;
        }

        System.out.println("Q.4. Which operator is used to access the value at the address stored in a pointer variable?");
        System.out.println("1. *");
        System.out.println("2. &");
        System.out.println("3. ->");
        System.out.println("4. ^");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 1) {
            count++;
        }

        System.out.println("Q.5. Which keyword is used to prevent any changes in the variable within a C program?");
        System.out.println("1. immutable");
        System.out.println("2. constant");
        System.out.println("3. final");
        System.out.println("4. const");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 4) {
            count++;
        }

        return count;
    }

    private static int cppQuestions() {
        int count = 0;
        int choice;

        System.out.println("Q.1. C++ was developed by:");
        System.out.println("1. Bjarne Stroustrup");
        System.out.println("2. Dennis Ritchie");
        System.out.println("3. James Gosling");
        System.out.println("4. Guido van Rossum");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 1) {
            count++;
        }

        System.out.println("Q.2. Which of the following is a valid constructor for the class named 'MyClass'?");
        System.out.println("1. MyClass();");
        System.out.println("2. MyClass.MyClass();");
        System.out.println("3. void MyClass();");
        System.out.println("4. int MyClass();");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 1) {
            count++;
        }

        System.out.println("Q.3. Which of the following is used to terminate the function declaration in C++?");
        System.out.println("1. :");
        System.out.println("2. ;");
        System.out.println("3. }");
        System.out.println("4. {");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 2) {
            count++;
        }

        System.out.println("Q.4. Which of the following is not a type of constructor in C++?");
        System.out.println("1. Default constructor");
        System.out.println("2. Parameterized constructor");
        System.out.println("3. Copy constructor");
        System.out.println("4. Virtual constructor");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 4) {
            count++;
        }

        System.out.println("Q.5. Which of the following is used to define the member function outside of the class?");
        System.out.println("1. :");
        System.out.println("2. .");
        System.out.println("3. ->");
        System.out.println("4. ::");
        System.out.print("Enter answer: ");
        choice = sc.nextInt();
        if (choice == 4) {
            count++;
        }

        return count;
    }

    private static void viewMarks() {
        int score = userScores.get(currentUser);
        System.out.println("Congrats " + currentUser + "! You scored " + score + " marks out of 5.");
    }

    private static void updateProfile() {
        System.out.println("1. Update Username");
        System.out.println("2. Update Password");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume the newline

        switch (choice) {
            case 1:
                System.out.print("Enter new username: ");
                String newUsername = sc.nextLine();
                if (userDatabase.containsKey(newUsername)) {
                    System.out.println("Username already exists. Please choose a different username.");
                } else {
                    userDatabase.put(newUsername, userDatabase.remove(currentUser));
                    userScores.put(newUsername, userScores.remove(currentUser));
                    currentUser = newUsername;
                    System.out.println("Username updated successfully.");
                }
                break;
            case 2:
                System.out.print("Enter new password: ");
                String newPassword = sc.nextLine();
                userDatabase.put(currentUser, newPassword);
                System.out.println("Password updated successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
