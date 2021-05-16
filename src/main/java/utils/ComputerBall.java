package utils;

import java.util.ArrayList;
import java.util.List;

public class ComputerBall {

    public static List<Integer> ball(int num) {
        while (true) {
            List<Integer> computerList = new ArrayList<>();
            int computer = RandomUtils.nextInt(ValidBall.MinBall(num), ValidBall.MaxBall(num));
            while (computer > 0) {
                computerList.add(computer % 10);
                computer /= 10;
            }
            int cnt = 0;
            for (int i = 0; i < computerList.toArray().length - 1; i++) {
                int number = computerList.get(i);
                for (int j = i + 1; j < computerList.toArray().length; j++) {
                    int check = computerList.get(j);
                    if (number == check || number == 0) {
                        cnt += 1;
                    }
                }
            }
            if (cnt == 0) {
                return computerList;
            }
        }
    }
}
