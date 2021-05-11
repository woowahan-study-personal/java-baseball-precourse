package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import utils.RandomUtils;

public class Application {

    public static void main(String[] args) {
//        final Scanner scanner = new Scanner(System.in);
//        System.out.println(RandomUtils.nextInt(100,999));
//        NumberGenerator generator = new NumberGenerator();
//        List<Integer> numbers = generator.createRandomNumbers();
//        System.out.println(numbers);
        Judgement judgement = new Judgement();
        int count = judgement.correctCount(
            Arrays.asList(1, 2, 4), Arrays.asList(4, 1, 2)
        );
        // ctrl + alt + L : 자동 포맷터(들여쓰기와 띄어쓰기 자동으로)
        System.out.println(count);
    }
}
