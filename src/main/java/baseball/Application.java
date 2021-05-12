package baseball;

import java.util.Scanner;
import utils.RandomUtils;
// ctrl + alt + L : 자동 포맷터(들여쓰기와 띄어쓰기 자동으로)

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int computer = RandomUtils.nextInt(100,999);
        System.out.println(computer);
    }
}
