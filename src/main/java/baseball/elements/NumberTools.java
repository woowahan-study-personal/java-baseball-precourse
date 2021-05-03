package baseball.elements;

import utils.RandomUtils;

public class NumberTools {

    private static final int minimumGameNumber = 123;
    private static final int maximumGameNumber = 987;
    private static final int digitLimit = 1;

    private NumberTools() {
    }

    public static boolean verify(int number) {
        String numberString = Integer.toString(number);

        if (minimumGameNumber > number || number > maximumGameNumber || numberString
            .contains("0")) {
            return false;
        }

        for (char digit : numberString.toCharArray()) {
            if (numberString.chars().filter(currentDigit -> currentDigit == digit).count()
                > digitLimit) {
                return false;
            }
        }

        return true;
    }

    public static int generateRandomNumber() {
        int targetGameNumber = RandomUtils.nextInt(minimumGameNumber, maximumGameNumber);

        while (!verify(targetGameNumber)) {
            targetGameNumber = RandomUtils.nextInt(minimumGameNumber, maximumGameNumber);
        }

        return targetGameNumber;
    }
}
