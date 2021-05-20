package game.ball;

import java.util.ArrayList;
import java.util.List;

public class Transforming {

    public static List<Integer> NumberList(int number) {
        List<Integer> resultList = new ArrayList<>();
        String temp = Integer.toString(number);
        for (int i = 0; i < temp.length(); i++){
            resultList.add((int) temp.charAt(i) - '0');
        }
        return resultList;
    }

}
