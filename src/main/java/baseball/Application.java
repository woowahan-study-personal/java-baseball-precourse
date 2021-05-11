package baseball;

import com.sun.tools.jdeprscan.scan.Scan;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import utils.RandomUtils;
// ctrl + alt + L : 자동 포맷터(들여쓰기와 띄어쓰기 자동으로)

public class Application {

    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> computer = generator.createRandomNumbers();

        Referee referee = new Referee();
        String result = "";
        while (!(result.equals("0볼 3스트라이크"))){
            result = referee.compare(computer, askNumbers());
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }
    public static List<Integer> askNumbers(){
        System.out.println("숫자를 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split("")){
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }
}
