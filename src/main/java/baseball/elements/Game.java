package baseball.elements;

public class Game {

    private static final int targetStrikeCount = 3;
    private final String gameNumber;

    public Game() {
        this.gameNumber = makeNewNumber();
    }

    private String makeNewNumber() {
        return Integer.toString(NumberTools.generateRandomNumber());
    }

    private String getGameNumber() {
        return this.gameNumber;
    }

    public boolean checkGame(Match match) {
        return match.getStrike() == targetStrikeCount;
    }

    public Match runMatch(String givenNumber) {
        return Match.receiveMatchResultByNumbers(this.getGameNumber(), givenNumber);
    }
}
