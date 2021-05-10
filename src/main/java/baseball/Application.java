package baseball;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;

import utils.RandomUtils;

public class Application {
    private static final int lenOfCount = 3;
    private static Boolean isReplay = true;
    private static Boolean isOver = true;
    private static int cntBall = 0;
    private static int cntStrike = 0;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        while (isReplay) {
            int[] userNum = new int[lenOfCount];
            int[] randNum = new int[lenOfCount];
            Set<Integer> randSet = new HashSet<Integer>();
            isOver = true;
            setRandomNum(randSet, randNum);

            while (isOver) {
                cntBall = 0;
                cntStrike = 0;

                System.out.println("Input numbers : ");
                int userInput = scanner.nextInt();

                setUserNum(userNum, userInput);

                cntCounter(userNum, randNum);

                checkCounter(cntBall, cntStrike);

                if (cntStrike == lenOfCount) {
                    isOver = false;
                }
            }
        
            System.out.println("Enter 1 to start a new game, 2 to end the game.");
            int tmp = scanner.nextInt();
            askReplay(tmp);
        }
        scanner.close();
    }

    private static void cntCounter(int[] userNum, int[] randNum) {
        for (int i = 0; i < lenOfCount; i++) {
            cntStrike = countStrike(userNum, randNum, i, cntStrike);
            cntBall = countBall(userNum, randNum, i, cntBall);
        }
    }

    public static void askReplay(int tmp) {
        int replayBT = 1;
        int stopBT = 2;
        if (tmp == replayBT) {
            isReplay = true;
        } else if (tmp == stopBT) {
            isReplay = false;
        } else {
            throw new IllegalArgumentException("Enter 1 or 2");
        }
    }

    public static void checkCounter(int cntBall, int cntStrike) {
        if (cntBall == 0 && cntStrike == 0) {
            System.out.println("Nothing");
        } else if (cntBall == 0) {
            System.out.println(cntStrike + "Strike");
        } else if (cntStrike == 0) {
            System.out.println(cntBall + "Ball");
        } else {
            System.out.println(cntBall + "Ball" + cntStrike + "Strike");
        }
    }

    public static void setUserNum(int[] userNum, int userInput) {

        for (int i = 0; i < lenOfCount; i++) {
            userNum[i] = userInput % 10;
            userInput /= 10;
        }
    }

    public static void setRandomNum(Set<Integer> randSet, int[] randNum) {
        do {
            randSet.add(RandomUtils.nextInt(1, 9));
        } while (randSet.size() < lenOfCount);
        Iterator<Integer> iter = randSet.iterator();
        for (int i = 0; i < lenOfCount; i++) {
            randNum[i] = (int) iter.next();
        }
    }

    public static int countStrike(int[] user, int[] com, int i, int st) {
        if (user[i] == com[i]) {
            st++;
        }
        return st;
    }

    public static int countBall(int[] user, int[] com, int i, int bl) {
        for (int j = 0; j < lenOfCount; j++) {
            if (i != j && user[i] == com[j]) {
                bl++;
            }
        }
        return bl;
    }
}
