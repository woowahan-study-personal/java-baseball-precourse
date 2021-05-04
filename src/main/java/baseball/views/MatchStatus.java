package baseball.views;

import baseball.elements.Match;

public class MatchStatus {

    private static final int minimumNumbersToPrint = 1;

    private MatchStatus() {
    }

    public static void showMatchResult(Match match) {
        if (match.getBall() >= minimumNumbersToPrint) {
            System.out.print(match.getBall() + "볼 ");
        }

        if (match.getStrike() >= minimumNumbersToPrint) {
            System.out.print(match.getStrike() + "스트라이크 ");
        }

        if (match.getBall() < minimumNumbersToPrint && match.getStrike() < minimumNumbersToPrint) {
            System.out.print("낫싱");
        }

        System.out.println();
    }
}
