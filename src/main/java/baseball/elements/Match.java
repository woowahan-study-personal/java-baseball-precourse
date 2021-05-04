package baseball.elements;

public class Match {

    private int ball = 0;
    private int strike = 0;

    private Match(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public static Match receiveMatchResultByNumbers(String givenNumber, String targetNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < givenNumber.length(); i++) {
            if (givenNumber.charAt(i) == targetNumber.charAt(i)) {
                strike++;
            } else if (targetNumber.indexOf(givenNumber.charAt(i)) != -1) {
                ball++;
            }
        }

        return new Match(ball, strike);
    }
}
