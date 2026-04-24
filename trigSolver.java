import java.util.Scanner;

// this is program for solve trig problems
// i made it with menu so user can picking what to do
public class practice {

    // main method where everything is starting
    public static void main(String[] args) {
        // scanner for reading what user is typing on keyboard
        Scanner scanner = new Scanner(System.in);
        // this boolean keeping track if we should keep running loop
        boolean running = true;

        System.out.println("  __  __           _        ____        ");
        System.out.println(" |  \\/  |         | |      |  _ \\       ");
        System.out.println(" | \\  / | __ _  __| | ___  | |_) |_   _ ");
        System.out.println(" | |\\/| |/ _` |/ _` |/ _ \\ |  _ <| | | |");
        System.out.println(" | |  | | (_| | (_| |  __/ | |_) | |_| |");
        System.out.println(" |_|  |_|\\__,_|\\__,_|\\___| |____/ \\__, |");
        System.out.println("                                   __/ |");
        System.out.println("                                  |___/ ");
        System.out.println("                                                                                    ");
        System.out.println("                                                                                    ");
        System.out.println("▄▄ ▄▄  ▄▄▄   ▄▄▄▄  ▄▄▄▄  ▄▄▄  ▄▄   ▄▄  ▄▄▄  ▄▄ ▄▄  ▄▄▄  ▄▄   ▄▄ ▄▄   ▄▄ ▄▄▄▄▄ ▄▄▄▄  ");
        System.out.println("██▄██ ██▀██ ███▄▄ ███▄▄ ██▀██ ██▀▄▀██ ██▀██ ██▄██ ██▀██ ██▀▄▀██ ██▀▄▀██ ██▄▄  ██▀██ ");
        System.out.println("██ ██ ██▀██ ▄▄██▀ ▄▄██▀ ██▀██ ██   ██ ▀███▀ ██ ██ ██▀██ ██   ██ ██   ██ ██▄▄▄ ████▀ ");

        System.out.println("Welcome to the Trigonometry Problem Solver!");

        // while loop for keeping program alive until user say stop
        while (running) {
            // printing the menu for user to look at
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Find hypotenuse (given two legs)");
            System.out.println("2. Find a leg (given hypotenuse and one leg)");
            System.out.println("3. Calculate Sine, Cosine, and Tangent (given an angle)");
            System.out.println("4. Find an angle (given opposite and adjacent legs)");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice (1-5): ");

            // getting the choice from user input
            String choice = scanner.nextLine();

            // switch statement for checking what user picked
            switch (choice) {
                case "1":
                    solveHypotenuse(scanner); // calling method for hypotenuse
                    break;
                case "2":
                    solveLeg(scanner); // calling method for finding leg
                    break;
                case "3":
                    solveTrigFunctions(scanner); // calling method for sin cos tan
                    break;
                case "4":
                    solveAngle(scanner); // calling method for find angle
                    break;
                case "5":
                    // user want to exit so we saying goodbye and stopping loop
                    System.out.println("Exiting the solver. Goodbye!");
                    running = false;
                    break;
                default:
                    // if user type weird stuff we tell them it wrong
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        
        // closing scanner because it is good practice
        scanner.close();
    }

    // method for finding hypotenuse using pythagorean theorem
    private static void solveHypotenuse(Scanner scanner) {
        System.out.println("\n--- Find Hypotenuse ---");
        // try catch block so program not crash if user type letters instead of numbers
        try {
            System.out.print("Enter the length of the first leg (a): ");
            double a = Double.parseDouble(scanner.nextLine()); // converting string to double number
            System.out.print("Enter the length of the second leg (b): ");
            double b = Double.parseDouble(scanner.nextLine());

            // calculating math square root of a squared plus b squared
            double c = Math.sqrt((a * a) + (b * b));
            System.out.printf("The length of the hypotenuse (c) is: %.4f\n", c);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }

    // method for finding a leg when we know hypotenuse and other leg
    private static void solveLeg(Scanner scanner) {
        System.out.println("\n--- Find a Leg ---");
        try {
            System.out.print("Enter the length of the hypotenuse (c): ");
            double c = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter the length of the known leg (a): ");
            double a = Double.parseDouble(scanner.nextLine());

            // checking if leg is bigger than hypotenuse because that is impossible
            if (a >= c) {
                System.out.println("Error: The hypotenuse must be strictly greater than either leg.");
                return; // going back to menu
            }

            // doing math again but subtracting this time
            double b = Math.sqrt((c * c) - (a * a));
            System.out.printf("The length of the unknown leg (b) is: %.4f\n", b);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }

    // method for calculate sin cos tan functions
    private static void solveTrigFunctions(Scanner scanner) {
        System.out.println("\n--- Calculate Sin, Cos, Tan ---");
        try {
            System.out.print("Enter the angle in degrees: ");
            double angleDegrees = Double.parseDouble(scanner.nextLine());
            // java math uses radians so we converting degrees to radians first
            double angleRadians = Math.toRadians(angleDegrees);

            // printing out the answers for sin cos and tan
            System.out.printf("Sin(%.2f°) = %.4f\n", angleDegrees, Math.sin(angleRadians));
            System.out.printf("Cos(%.2f°) = %.4f\n", angleDegrees, Math.cos(angleRadians));
            System.out.printf("Tan(%.2f°) = %.4f\n", angleDegrees, Math.tan(angleRadians));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    // method for finding angle when we have two legs
    private static void solveAngle(Scanner scanner) {
        System.out.println("\n--- Find Angle (from opposite and adjacent legs) ---");
        try {
            System.out.print("Enter the length of the opposite leg: ");
            double opposite = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter the length of the adjacent leg: ");
            double adjacent = Double.parseDouble(scanner.nextLine());

            // using atan2 because it better for finding angle
            double angleRadians = Math.atan2(opposite, adjacent);
            // converting back to degrees so user can understand it
            double angleDegrees = Math.toDegrees(angleRadians);

            System.out.printf("The angle is: %.2f°\n", angleDegrees);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }
}
