package lastpencil;

import java.util.Scanner;

public class UI {
    private final Scanner scanner;

    public UI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("How many pencils would you like to use:");

        int numberOfPencils = getNumberOfPencils();

        System.out.println("Who will be the first (John, Jack):");

        String first = getFirstPlayer();
        String second = getSecondPlayer(first);

        Game game = new Game(first, second, numberOfPencils, scanner);

        game.play();

        System.out.printf("%s won!", game.getWinner());
    }

    private String getSecondPlayer(String first) {
        return first.equals("John") ? "Jack" : "John";
    }

    private String getFirstPlayer() {
        String first;

        while (true) {
            first = scanner.nextLine();

            if (InputValidator.isValidName(first)) {
                return first;
            }

            System.out.println(ErrorMessage.WRONG_NAME);
        }
    }

    private int getNumberOfPencils() {
        int number;

        while (true) {
            String numberInput = scanner.nextLine();

            if (!InputValidator.isNumber(numberInput)) {
                System.out.println(ErrorMessage.NOT_A_NUMBER);
                continue;
            }

            number = Integer.parseInt(numberInput);

            if (!InputValidator.isPositive(number)) {
                System.out.println(ErrorMessage.MUST_BE_POSITIVE);
                continue;
            }

            return number;
        }
    }
}