## 숫자야구게임

>  작성일시 : 21.05.01

### 🚀 기능 목록 순서

0 게임 전체반복 1while

1 3자리의 서로 다른 랜덤한 수를 만든다 : XYZ

```
0 게임 비교반복 2while

2 숫자 입력 : ABC

3 랜덤수 비교 (XYZ와 ABC) 카운트

- 숫자일치, 자리불일치 : N 볼
- 숫자일치, 자리일치 : M 스트라이크(<3)
- `N 볼 M 스트라이크` (N+M <= 3)
- 숫자불일치, 자리불일치 : `낫싱`

3-1 불일치-반복 2while

3-2 완전동일-탈출

- 숫자일치, 자리일치 : 3 스트라이크
```

4  전체반복여부 입력

4-1 if 2 break

4-2 if 1 이면, 1while으로 이동

※ 주의 : 2깊이, 3항연산지사용금지, 입력이상 IllegalArgumentException



### 🎱 기능 요소

- 랜덤 클래스

- 게임 클래스
  - 게임 반복
  - 숫자 비교 반복
  - 숫자 비교 카운트



### ✍🏻 공부

- 숫자 비교 :  XYZ와 ABC 의 가능한 입력 값 고민
  - 1 int (/100 /10 /1) 
  - 2 String (index)
  - 3 arr (index)

- 숫자 + 문자 = 문자
  - Integer.toString 를 자동으로
- nextInt; nextLine; - > Integer.parseInt(scanner.nextLine())



```java
package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean startGame = restartGame(scanner);
        int strike = 0;
        int ball = 0;
        // 1 게임 반복
        while (startGame) {
            // 랜덤수발생 randomNum

            // 2 입력 반복
            while (strike != 3) {
                // 내숫자입력 userNum
                // 랜덤수 = 내숫자비교 [f]
                // strike = 값;
                // ball = 값;
                // 볼/스 결과출력 [f]
                resultGame(ball, strike);
            }
            strike = 0;
            ball = 0;
            // f 게임 재시작 [f]
            startGame = restartGame(scanner);
        }
    }
    
    // 랜덤수 = 내숫자비교 [f]
    public static int[] compareNum(String randomNum, String userNum) {
    }
    
    // f 게임 재시작 [f]
    public static boolean restartGame(Scanner scanner) {
    }

    // 볼/스 결과출력 [f]
    public static void resultGame(int ball, int strike) {
        System.out.println("result");
    }

}

```

### 📈 Todo

예외처리

utf-8

상수화