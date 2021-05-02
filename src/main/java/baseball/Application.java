package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Let's play game~~~");

        boolean startGame = restartGame(scanner);
        int strike = 0;
        int ball = 0;
        
        // 1 게임 반복
        while (startGame) {
            // 랜덤수발생 randomNum
            String randomNum = "123";
            System.out.println("randomNum : "+randomNum);
            // 2 입력비교 반복
            while (strike != 3) {
                // 내숫자입력 userNum
                System.out.println("userNum : ");
                String userNum = scanner.nextLine();
                int[] compareResult = compareNum(randomNum, userNum);
                // 랜덤수 = 내숫자비교 [f]
                 ball = compareResult[0];
                 strike = compareResult[1];
                // 볼/스 결과출력 [f]
                resultGame(ball, strike);
            }
            strike = 0;
            ball = 0;
            // 게임 재시작 [f]
            startGame = restartGame(scanner);
        }
    }

    // 랜덤수 = 내숫자비교 [f]
    public static int[] compareNum(String randomNum, String userNum) {
        int[] compareResult = {0,0};
        for (int i=0; i<userNum.length(); i++) {
            for (int j=0; j<randomNum.length(); j++) {
                if (userNum.substring(i, i + 1).equals(randomNum.substring(j, j + 1))) {
                    if(i == j) {
                        compareResult[1] += 1;
                    } else {
                        compareResult[0] += 1;
                    }
                }
            }
        }
        return compareResult;
    }

    // 게임 재시작 [f]
    public static boolean restartGame(Scanner scanner) {
        System.out.println("restart 1, end 2");
        int restartGameNum = Integer.parseInt(scanner.nextLine());
        if (restartGameNum != 1 && restartGameNum != 2) {
            throw new IllegalArgumentException("error");
        } else if (restartGameNum == 1) {
            return true;
        }
        return false;
    }

    // 볼/스 결과출력 [f]
    public static void resultGame(int ball, int strike) {
        String result = "";
        if (strike == 3) {
            result = "3 strike! end";
        } else if (ball == 0 && strike == 0) {
            result = "nothing";
        } else {
            if (ball != 0 && strike != 0) {
                result = ball +"ball "+ strike +"strike";
            }
            else if (ball != 0) {
                result = ball +"ball";
            }
            else if (strike != 0) {
                result = strike +"strike";
            }
        }
        System.out.println(result);
    }

}
