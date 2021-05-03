package baseball;

import baseball.elements.Game;
import baseball.elements.NumberTools;
import baseball.elements.Match;
import baseball.views.PlayerInput;
import baseball.views.MatchStatus;
import java.util.Scanner;

public class Application {
    private static boolean runGame = true;

    private static void gameRun(Scanner sc) {
        Game game = new Game();

        while (true) {
            int playerNumber = PlayerInput.askPlayerNumber(sc);

            if (!NumberTools.verify(playerNumber)) {
                System.out.print("허용된 숫자는 0을 포함하지 않는 정수 111 ~ 999까지입니다. 다시 입력하시기 바랍니다");
                continue;
            }

            Match match = game.submitNumber(Integer.toString(playerNumber));
            MatchStatus.showMatchResult(match);

            if (game.checkGame(match)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while(runGame) {
            gameRun(scanner);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            runGame = PlayerInput.askNewGame(scanner);
        }
    }
}
