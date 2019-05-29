import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class NumberGuesser {
    // Console colors
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET_CONSOLE_COLOR = "\u001B[0m";
    // This buffered reader class has similar function to C#'s Console.Readline. I'll give C# props, it's much easier to do in C#
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        GetAppInfo();
        GreetUser();

        while (true) {

            Random randNum = new Random();
            Integer correctNumber = randNum.nextInt(11);
            Integer guess = 0;

            System.out.println("Guess a number between one and ten");

            while (!correctNumber.equals(guess)) { // don't use == or != for Object types (Big I Integer) -- only reliable for lower I int

                String input = reader.readLine();
                guess = tryParse(input);

                if (guess == null) {
                    System.out.println(RED + "That's not a number Karen, try entering a number");
                    continue;
                }

                if (guess != correctNumber) {
                    PrintColorMessage(RED, "Wrong number. Please try again...");
                }

            }

            System.out.println(YELLOW + "You guessed correct");
            System.out.println("Play again? ['Y' for yes | 'N' for no]");

            String answer = reader.readLine().toUpperCase();

            if ("y".equals(answer.toLowerCase())) {
                continue;
            }
            else if (answer == "N") {
                return;
            } else {
                return;
            }
        }
    }

    private static void GetAppInfo() {
        // App meta data
        String appName = "Number Guesser";
        String appVersion = "1.0.0";
        String appAuthor = "Moose Archer";


        System.out.println(GREEN + appName + ": Version " + appVersion + " by " + appAuthor + RESET_CONSOLE_COLOR);

    }

    private static void GreetUser() throws IOException {

        System.out.println("What is your name?");

        String inputName = reader.readLine();

        System.out.println("Hello, " + inputName + " let's play a game!" + RESET_CONSOLE_COLOR);
    }

    private static void PrintColorMessage(String color, String message) {

        System.out.println(color + message + RESET_CONSOLE_COLOR);

    }

    private static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}