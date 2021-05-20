package views;

import java.util.List;
import java.util.Scanner;

public class View {

    public static void InsertNumber(){
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void Start() {
        System.out.print("숫자를 입력해 주세요 : ");
    }
    public static void DuplicateError() {
        System.out.println("각 .0숫자는 한 번씩만 사용해 주세요.");
    }

    public static void LengthError(int num) {
        System.out.println(num+"자리의 숫자를 입력해 주세요");
    }
    public static String Result(List<Integer> SandB) {
        int strike = SandB.get(0);
        int ball = SandB.get(1);
        String result = "";
        if (ball != 0 && strike != 0) {
            result = ball + "볼 " + strike + "스트라이크";
        } else if (strike != 0) {
            result = strike + "스트라이크";
        } else if (ball != 0 ) {
            result = ball + "볼";
        } else {
            result = "낫싱";
        }
        return result;
    }


//    게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.

}
