package utils;

import java.util.ArrayList;

public class ValidBall {

    public static int MinBall(int num) {
        int result = 0;
        for (int i = 1; i < 10; i++) {
            result *= 10;
            result += i;
            if (i == num) {
                return result;
            }
        }
        return result;
    }

    public static int MaxBall(int num) {
        int result = 0;
        for (int i = 9; i > 0; i--) {
            result *= 10;
            result += i;
            if ((10 - i) == num) {
                return result;
            }
        }
        return result;
    }
}
