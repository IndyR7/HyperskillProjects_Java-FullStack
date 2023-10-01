package lastpencil;

import java.util.Random;

public class Bot {
    public static int getMove(int numberOfPencils) {
        switch (numberOfPencils) {
            case 1, 2 -> {
                return 1;
            }
            case 3 -> {
                return 2;
            }
            default -> {
            }
        }

        switch (numberOfPencils % 4) {
            case 1 -> {
                return new Random().nextInt(3) + 1;
            }
            case 2 -> {
                return 1;
            }
            case 3 -> {
                return 2;
            }
            default -> {
                return 3;
            }
        }
    }
}