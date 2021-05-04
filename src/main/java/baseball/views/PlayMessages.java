package baseball.views;

public class PlayMessages {

    private PlayMessages() {
    }

    public static void notAllowedNumberRangeMessage() {
        System.out.print("입력이 허용된 숫자는 0을 포함하지 않는 정수 111 ~ 999까지입니다. 다시 입력하시기 바랍니다: ");
    }

    public static void askNumberInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void askPlayNewGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void gameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
