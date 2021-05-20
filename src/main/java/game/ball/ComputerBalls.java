package game.ball;

import game.Check;
import utils.RandomUtils;

public class ComputerBalls {

    public static int Value(int length) {
        int minNumber = 0;
        int maxNumber = 0;
        for (int i = 1; i <= length; i++) {
            minNumber *= 10;
            minNumber += i;
            maxNumber *= 10;
            maxNumber += (10 - i);
        }
        return RandomUtils.nextInt(minNumber, maxNumber);
    }

    public static int ComputerBall(int lengthNumber) {
        while (true) {
            int checkNumber = Value(lengthNumber);
            if (Check.ValidBalls(checkNumber)) {
                return checkNumber;
            }
        }
    }

}
