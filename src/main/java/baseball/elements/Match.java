package baseball.elements;

public class Match {

    private int ball = 0;
    private int strike = 0;

    private Match() {
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public static Match receiveMatchResultByNumbers(String givenNumber, String targetNumber) {
        Match match = new Match();

        for (int i = 0; i < givenNumber.length(); i++) {
            if (givenNumber.charAt(i) == targetNumber.charAt(i)) {
                match.strike += 1;
            } else if (targetNumber.indexOf(givenNumber.charAt(i)) != -1) {
                match.ball += 1;
            }
        }

        return match;
    }
}
