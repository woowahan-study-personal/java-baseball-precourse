package baseball;

import game.MainGame;

import java.util.Scanner;
// ctrl + alt+ L : 자동 포맷터(들여쓰기와 띄어쓰기 자동으로)

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberLength = 3;
        MainGame.playGame(numberLength, scanner);
    }
}
