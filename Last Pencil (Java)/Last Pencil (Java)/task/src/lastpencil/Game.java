package lastpencil;

import java.util.Scanner;

public class Game {
    private final int startingNumber;
    private final String first;
    private final String second;
    private String pencils;
    private String winner;
    private final Scanner scanner;

    public Game(String first, String second, int startingNumber, Scanner scanner) {
        this.startingNumber = startingNumber;
        this.first = first;
        this.second = second;
        this.scanner = scanner;
    }

    public void play() {
        int turn = 0;
        pencils = createPencils(startingNumber);

        while (pencils.length() > 0) {
            System.out.println(pencils);

            String currentPlayer = turn++ % 2 == 0 ? first : second;

            System.out.printf("%s's turn!\n", currentPlayer);

            pencils = createPencils(pencils.length() - getNumberToRemove(currentPlayer));
        }

        this.winner = turn % 2 == 0 ? first : second;
    }

    public String getWinner() {
        return winner;
    }

    private int getNumberToRemove(String currentPlayer) {
        int number;

        if (currentPlayer.matches("Jack")) {
            number = Bot.getMove(pencils.length());

            System.out.println(number);

            return number;
        }

        while (true) {
            String input = scanner.nextLine();

            if (!InputValidator.isValidNumberToRemove(input)) {
                System.out.println(ErrorMessage.WRONG_NUMBER);
                continue;
            }

            number = Integer.parseInt(input);

            if (!InputValidator.isWithinBounds(number, pencils.length())) {
                System.out.println(ErrorMessage.OUT_OF_BOUNDS);
                continue;
            }

            return number;
        }
    }

    private String createPencils(int number) {
        return "|".repeat(Math.max(0, number));
    }
}