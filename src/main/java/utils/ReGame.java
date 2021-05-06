package utils;

public enum ReGame {
    REGAME(1), STOP(2);

    private final int value;

    private ReGame(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
