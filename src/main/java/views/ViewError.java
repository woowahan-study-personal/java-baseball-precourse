package views;

public class ViewError {

    public static void duplicateError() {
        System.out.println("각 숫자는 한 번씩만 사용해 주세요.");
    }

    public static void lengthError(int num) {
        System.out.println(num + "자리의 숫자를 입력해 주세요");
    }

    public static void numberError() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
