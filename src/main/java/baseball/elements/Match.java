package baseball.elements;

public class Match {
    private int ball = 0;
    private int strike = 0;

    public Match(String givenNumber, String targetNumber) {
        for (int i = 0; i < givenNumber.length(); i++) {
            if (givenNumber.charAt(i) == targetNumber.charAt(i)) {
                strike += 1;
            } else if (targetNumber.indexOf(givenNumber.charAt(i)) != -1) {
                ball += 1;
            }
        }
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }
}
