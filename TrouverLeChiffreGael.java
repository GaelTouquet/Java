import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class TrouverLeChiffreGael {
    // Gael

    public static String usernameRequest(Scanner saisie) {
        System.out.print("Hello! what is your username? ");
        String userName = saisie.nextLine();
        return userName;
    }

    public static boolean userYesOrNo(String message, Scanner saisie) {
        ArrayList<String> reponseY = new ArrayList<>(Arrays.asList("yes", "y"));
        ArrayList<String> reponseN = new ArrayList<>(Arrays.asList("no", "n"));
        while (true) {
            System.out.print(String.format("%s : yes or no? ", message));
            String userInput = saisie.nextLine();
            if (reponseY.contains(userInput))
                return true;
            if (reponseN.contains(userInput))
                return false;
        }
    }

    public static int userIntRequest(String message, Scanner saisie) {
        int output = 0;
        while (true) {
            System.out.print(message);
            try {
                String userInput = saisie.nextLine();
                output = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Must be an integer!");
                continue;
            }
            return output;
        }
    }

    public static int userStrictlyPositiveIntRequest(String message, Scanner saisie) {
        while (true) {
            int userInt = userIntRequest(message, saisie);
            if (userInt > 0)
                return userInt;
            System.out.print("Must be an integer!");
        }
    }

    public static void play(int maxVal, int nGuess, String userName, Random rn, Scanner saisie) {
        int guess; // initialise guess just out of the range, at upper bound
        int randomNum = rn.nextInt(maxVal - 1) + 1; // allowed numbers start at 1 and finish with maxVal
        int iGuess = 0;
        while (true) {
            guess = userIntRequest(String.format("Guess the number between 1 and %d ", maxVal), saisie);
            iGuess++;
            if (guess == randomNum) {
                System.out.println(String.format("Success %s, congratulation!!!", userName));
                break;
            } else if (guess < randomNum) {
                System.out.println(String.format("Sorry %s, too low!", userName));
            } else {
                System.out.println(String.format("Sorry %s, too high!", userName));
            }
            if (iGuess >= nGuess) {
                System.out.println(String.format("Sorry %s, that was your last guess!", userName));
                break;
            }
        }

    }

    public static Scanner saisie;

    public static void main(String[] args) {

        saisie = new Scanner(System.in);

        String userName = usernameRequest(saisie);

        int maxVal = userStrictlyPositiveIntRequest("What is the maximum value of the guessed number? ", saisie);

        int maxAttempts = userStrictlyPositiveIntRequest("How many tries should you get? ", saisie);

        Random rn = new Random();

        while (true) {

            play(maxVal, maxAttempts, userName, rn, saisie);

            if (!userYesOrNo("Want to play again? ", saisie))
                break;
        }

        saisie.close();
    }
}