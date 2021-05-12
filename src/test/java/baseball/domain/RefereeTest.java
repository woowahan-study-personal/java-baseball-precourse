package baseball.domain;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
// alt + insert를 통해서 test method 생성
public class RefereeTest {

    @Test
    void 스트라이크3() {
        Referee referee = new Referee();
        String result = referee.compare(Arrays.asList(1,2,3), Arrays.asList(1,2,3));

    }
}
