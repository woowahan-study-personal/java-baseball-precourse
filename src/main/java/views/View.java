package views;

import java.util.List;

public class View {

    public static void start() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static String result(List<Integer> SandB) {
        int strike = SandB.get(0);
        int ball = SandB.get(1);
        String result;
        if (ball != 0 && strike != 0) {
            result = ball + "볼 " + strike + "스트라이크";
        } else if (strike != 0) {
            result = strike + "스트라이크";
        } else if (ball != 0) {
            result = ball + "볼";
        } else {
            result = "낫싱";
        }
        return result;
    }

    public static void endGame(int num) {
        System.out.println(num + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
