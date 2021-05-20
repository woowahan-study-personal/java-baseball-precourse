package views;

import java.util.Scanner;

public class View {

    public static void InsertNumber(){
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void Start() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void DuplicateError() {
        System.out.println("숫자는 한 번씩만 사용해 주세요.");
    }

    public static void LengthError(int num) {
        System.out.println(num+"자리의 숫자를 입력해 주세요");
    }
//        if (ball != 0 && strike != 0) {
//            System.out.print(ball + "볼 " + strike + "스트라이크");
//        } else if (strike != 0) {
//            System.out.print(strike + "스트라이크");
//        } else if (ball != 0 ) {
//            System.out.print(ball + "볼");
//        } else {
//            System.out.println("낫싱");
//        }
//    }

//    게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.

}
