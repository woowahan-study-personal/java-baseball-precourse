package baseball;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;
import utils.RandomUtils;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Boolean isReplay = true;

        while (isReplay) {
            int[] userNum = new int[3];
            int[] randNum = new int[3];
            Set<Integer> randSet = new HashSet<Integer>();
            Boolean isOver = true;

            setRandomNum(randSet, randNum);

            while (isOver) {
                int cntBall = 0;
                int cntStrike = 0;
                int lenOfCount = 3;

                System.out.println("Input numbers : ");
                int userInput = scanner.nextInt();

                setUserNum(userNum, userInput);

                for (int i = 0; i < lenOfCount; i++) {
                    cntStrike = countStrike(userNum, randNum, i, cntStrike);
                    cntBall = countBall(userNum, randNum, i, cntBall);
                }

                isOver = checkCounter(cntBall, cntStrike, isOver);
            }
            if (!isOver) {
                System.out.println("Enter 1 to start a new game, 2 to end the game.");
                int tmp = scanner.nextInt();
                isReplay = askReplay(tmp);
            }
        }
        scanner.close();
    }

    public static Boolean askReplay(int tmp) {
        boolean check = false;
        if(tmp == 1){
            check = true;
        }else if(tmp == 2){
            check = false;
        }else{
            throw new IllegalArgumentException("Enter 1 or 2");
        }
        return check;
    }

    public static boolean checkCounter(int cntBall, int cntStrike, boolean isOver) {
        if(cntBall == 0 && cntStrike == 0){
            System.out.println("Nothing");
        }else if(cntStrike == 3){
            System.out.println(cntStrike + "Strike");
            isOver = false;
        }else if(cntBall == 0){
            System.out.println(cntStrike + "Strike");
        }else if(cntStrike == 0){
            System.out.println(cntBall + "Ball");
        }else{
            System.out.println(cntBall + "Ball" + cntStrike + "Strike");
        }

        return isOver;
    }

    public static void setUserNum(int[] userNum, int userInput) {
        for (int i = 0; i < 3; i++) {
            userNum[i] = userInput % 10;
            userInput /= 10;
        }
    }

    public static void setRandomNum(Set<Integer> randSet, int[] randNum) {
        do {
            randSet.add(RandomUtils.nextInt(1, 9));
        } while (randSet.size() < 3);
        Iterator iter = randSet.iterator();
        for (int i = 0; i < 3; i++) {
            randNum[i] = (int) iter.next();
        }
    }


    public static int countStrike(int[] user, int[] com, int i, int st){
        if (user[i] == com[i]) {
            st++;
        }
        return st;
    }
    public static int countBall(int[] user, int[] com, int i, int bl){
        for(int j=0; j<3; j++) {
            if(i != j && user[i] == com[j]){
                bl++;
            }
        }
        return bl;
    }


}
