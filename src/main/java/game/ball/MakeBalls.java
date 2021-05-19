package game.ball;

import utils.RandomUtils;

import java.util.List;

public class MakeBalls {
    public static int Value(int length){
        int minNumber = 0;
        int maxNumber = 0;
        for (int i=1;i<=length;i++){
            minNumber *= 10;
            minNumber += i;
            maxNumber *= 10;
            maxNumber += (10-i);
        }
        return RandomUtils.nextInt(minNumber,maxNumber);
    }

}
