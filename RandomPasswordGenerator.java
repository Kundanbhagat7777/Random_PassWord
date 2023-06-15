import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {

    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_-+=<>?";

    public static void main(String[] args) {
        int length = getPasswordLength();
        boolean useLowercase = getChoice("Include lowercase letters? (y/n): ");
        boolean useUppercase = getChoice("Include uppercase letters? (y/n): ");
        boolean useNumbers = getChoice("Include numbers? (y/n): ");
        boolean useSpecialCharacters = getChoice("Include special characters? (y/n): ");

        String password = generatePassword(length, useLowercase, useUppercase, useNumbers, useSpecialCharacters);
        System.out.println("Generated Password: " + password);
    }

    public static int getPasswordLength() {
        Scanner scanner = new Scanner(System.in);
        int length;

        do {
            System.out.print("Enter the desired password length: ");
            length = scanner.nextInt();
            if (length <= 0) {
                System.out.println("Invalid password length. Please enter a positive number.");
            }
        } while (length <= 0);

        return length;
    }

    public static boolean getChoice(String message) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.print(message);
            choice = scanner.nextLine().toLowerCase();
            if (!choice.equals("y") && !choice.equals("n")) {
                System.out.println("Invalid choice. Please enter 'y' or 'n'.");
            }
        } while (!choice.equals("y") && !choice.equals("n"));

        return choice.equals("y");
    }

    public static String generatePassword(int length, boolean useLowercase, boolean useUppercase, boolean useNumbers, boolean useSpecialCharacters) {
        StringBuilder characters = new StringBuilder();

        if (useLowercase) {
            characters.append(LOWERCASE_LETTERS);
        }

        if (useUppercase) {
            characters.append(UPPERCASE_LETTERS);
        }

        if (useNumbers) {
            characters.append(NUMBERS);
        }

        if (useSpecialCharacters) {
            characters.append(SPECIAL_CHARACTERS);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}
