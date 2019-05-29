using System;

namespace NumberGuesser_Moose
{
    public class Program
    {
        static void GetAppInfo()
        {
            string appName = "Number Guesser";
            string appVersion = "1.0.0";
            string appAuthor = "Moose Archer";

            // Changes console font color
            Console.ForegroundColor = ConsoleColor.DarkGreen;

            // Better way of using variable values in a string; elimates need for second parameter references after the string
            Console.WriteLine($"{appName}: Version {appVersion} by {appAuthor}");

            // Reset text color
            Console.ResetColor();
        }

        static void GreetUser()
        {
            Console.WriteLine("What is your name?");

            // Get user's name
            string inputName = Console.ReadLine();

            Console.WriteLine($"Hello, {inputName}, let's play a game!");
        }

        static void PrintColorMessage(ConsoleColor color, string message)
        {
            Console.ForegroundColor = color;
            Console.WriteLine(message);
            Console.ResetColor();
        }

        public static void Main(string[] args)
        {
            GetAppInfo();

            GreetUser();

            // Set initial correct number
            //int correctNumber = 7;

            while (true)
            {

                Random randomNumber = new Random();
                int correctNumber = randomNumber.Next(1, 11);

                // Initial guess 
                int guess = 0;

                // Ask user for number
                Console.WriteLine("Guess a number between 1 and 10:");

                // While guess isn't correct
                while (guess != correctNumber)
                {
                    // Get users input
                    string input = Console.ReadLine();

                    // Check if it's a number
                    if (!int.TryParse(input, out guess))
                    {
                        // Print color error message
                        PrintColorMessage(ConsoleColor.Red, "Please use an actual number."); 
                        // Keeps going through code
                        continue;
                    }

                    // Cast to int and put in guess
                    guess = Int32.Parse(input);

                    if (guess != correctNumber)
                    {
                        // Print color error message
                        PrintColorMessage(ConsoleColor.Red, "Wrong number, please try again.");
                    }

                }

                // Print color success message
                PrintColorMessage(ConsoleColor.Yellow, "CORRECT! OH BOY OH BOY OH BOY OH BOY!");

                // Ask user to play again
                Console.WriteLine("Play Again? ['Y' for yes | 'N' for no]");

                // Get Answer
                string answer = Console.ReadLine().ToUpper();

                if (answer == "Y")
                {
                    continue;
                } 
                else if (answer == "N")
                {
                    return;
                }
                else
                {
                    return;
                }
            }
        }
    }
}
