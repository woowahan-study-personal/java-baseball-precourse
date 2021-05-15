package baseball;

import java.util.List;
import java.util.Scanner;
import utils.ComputerBall;
// ctrl + alt+ L : 자동 포맷터(들여쓰기와 띄어쓰기 자동으로)

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        List<Integer> computerList = ComputerBall.ball(3);
        System.out.println(computerList);
        String answer = "";
        while (!(answer.equals("3스트라이크"))) {
            System.out.println("숫자를 입력해주세요");
            int a = scanner.nextInt();
            answer = Checking.CompareNumber(computerList, a);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int coin = scanner.nextInt();
            if (coin == 2) {
                return;
            } else if (coin == 1) {
                Application.main(args);
                break;
            }
        }


    }
}
