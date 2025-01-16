import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        String[] choices = {"gu", "pa", "tyoki"};

        while (true) {
            System.out.println("Enter your choice (gu, pa, Scissors). Type 'exit' to quit:");
            String userChoice = scanner.nextLine().trim();

            if (userChoice.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;
            }

            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid choice, please enter gu, pa, or Scissors.");
                continue;
            }

            String computerChoice = choices[random.nextInt(3)];

            System.out.println("You chose: " + userChoice);
            System.out.println("Computer chose: " + computerChoice);

            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);
        }

        scanner.close();
    }

    public static boolean isValidChoice(String choice) {
        return choice.equalsIgnoreCase("gu") || choice.equalsIgnoreCase("pa") || choice.equalsIgnoreCase("Scissors");
    }

    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            return "It's a tie!";
        }

        if ((userChoice.equalsIgnoreCase("gu") && computerChoice.equalsIgnoreCase("Scissors")) ||
            (userChoice.equalsIgnoreCase("pa") && computerChoice.equalsIgnoreCase("gu")) ||
            (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("pa"))) {
            return "You win!";
        }
        return "負け";
    }
}
