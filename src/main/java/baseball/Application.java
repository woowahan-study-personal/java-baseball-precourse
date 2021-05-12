package baseball;

import java.util.LinkedList;
import java.util.Scanner;
import utils.RandomUtils;
// ctrl + altd+ L : 자동 포맷터(들여쓰기와 띄어쓰기 자동으로)

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int coin = 1;
        while (coin==1) {

            int computer = RandomUtils.nextInt(100, 999);
            LinkedList<Integer> computerList = new LinkedList<Integer>();
            while (computer > 0) {
                computerList.push(computer % 10);
                computer /= 10;
            }
            System.out.println(computerList);
            String answer = "";
            while (!(answer.equals("3스트라이크"))) {
                System.out.println("숫자를 입력해주세요");
                int a = scanner.nextInt();
                answer = Checking.CompareNumber(computerList, a);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            coin = scanner.nextInt();
        }

    }
}
