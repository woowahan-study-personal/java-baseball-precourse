package views;

public class Error {

    public static void DuplicateError() {
        System.out.println("각 숫자는 한 번씩만 사용해 주세요.");
    }

    public static void LengthError(int num) {
        System.out.println(num+"자리의 숫자를 입력해 주세요");
    }
}
