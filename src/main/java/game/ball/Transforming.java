package game.ball;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transforming {

    public static List<Integer> NumberList(int number) {
        List<Integer> resultList = new ArrayList<>();
        String temp = Integer.toString(number);
        for (int i = 0; i < temp.length(); i++){
            resultList.add(Integer.parseInt(String.valueOf(temp.charAt(i))));
        }
        return resultList;
    }

}
