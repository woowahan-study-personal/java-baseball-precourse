package game.ball;

import utils.RandomUtils;

public class ComputerBalls {

    public static int value(int length) {
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

    public static int computerBall(int lengthNumber) {
        while (true) {
            int checkNumber = value(lengthNumber);
            if (Check.validBalls(checkNumber)) {
                return checkNumber;
            }
        }
    }

}
