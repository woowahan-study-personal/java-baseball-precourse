package baseball;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import utils.RandomUtils;
// ctrl + alt + L : 자동 포맷터(들여쓰기와 띄어쓰기 자동으로)

public class Application {

    public static void main(String[] args) {
        Referee referee = new Referee();
        String result = referee.compare(Arrays.asList(3,1,2), Arrays.asList(1,2,3));
        System.out.println(result);

    }
}
