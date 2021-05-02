package baseball;

import utils.RandomUtils;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Let's play game");

        boolean startGame = restartGame(scanner);
        int strike = 0;
        int ball = 0;

        // 1 게임 반복
        while (startGame) {
            // 랜덤수발생 randomNum
            String randomNum = getRandomNum();
             System.out.println("[미리보는 정답] : "+randomNum);
            // 2 입력비교 반복
            while (strike != 3) {
                // 내숫자입력 userNum
                System.out.print("숫자를 입력해주세요 : ");
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

    // 랜덤수발생 [f]
    public static String getRandomNum() {
        // 중복없는 랜덤수 만들기
        int randomArr[] = new int[3];
        for (int i=0; i<3; i++) {
            randomArr[i] = RandomUtils.nextInt(1,9);
            for (int j=0; j<i; j++) {
                if(randomArr[i]==randomArr[j]){
                    i--;
                }
            }
        }
        String randomNum = Integer.toString(randomArr[0])+Integer.toString(randomArr[1])+Integer.toString(randomArr[2]);
//        System.out.println(rn);
        return randomNum;
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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
            result = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else if (ball == 0 && strike == 0) {
            result = "낫싱";
        } else {
            if (ball != 0 && strike != 0) {
                result = ball +"볼 "+ strike +"스트라이크";
            }
            else if (ball != 0) {
                result = ball +"볼";
            }
            else if (strike != 0) {
                result = strike +"스트라이크";
            }
        }
        System.out.println(result);
    }

}
