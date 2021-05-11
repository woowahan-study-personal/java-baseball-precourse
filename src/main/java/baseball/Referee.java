package baseball;

import java.util.List;

public class Referee {

    public String compare(List<Integer> computer, List<Integer> player) {
        // 몇 개의 숫자가 같은지 알아낸다.
        // 스트라이크 개수를 구해 뺀다. => 나머지는 볼의 개수

        Judgement judgement = new Judgement();
        int correctCount = judgement.correctCount(computer, player);
        int strike = 0;
        for (int placeIndex = 0; placeIndex < computer.size(); placeIndex++) {
            if (judgement.hasPlace(computer, placeIndex, player.get(placeIndex))) {
                strike++;
            }
        }
        int ball = correctCount - strike;
        return ball + "볼" + strike + "스트라이크";
    }


}
