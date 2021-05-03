package baseball;

import baseball.elements.Game;
import baseball.elements.Match;
import baseball.views.PlayMessages;
import baseball.views.PlayerInput;
import baseball.views.MatchStatus;
import java.util.Scanner;

public class Application {

    private static boolean runGame = true;

    private static void gameRun(Scanner sc) {
        Game game = new Game();

        while (true) {
            Match match = game.runMatch(PlayerInput.askPlayerNumber(sc));
            MatchStatus.showMatchResult(match);

            if (game.checkGame(match)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (runGame) {
            gameRun(scanner);
            PlayMessages.gameEndMessage();
            runGame = PlayerInput.askNewGame(scanner);
        }
    }
}
