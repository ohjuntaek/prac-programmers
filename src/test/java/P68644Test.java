import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P68644Test {
    int[] numbers = {2, 1, 3, 4, 1};
    int[] result = {2, 3, 4, 5, 6, 7};
    P68644 p68644 = new P68644();

    @Test
    void test() {
        int[] solution = p68644.solution(numbers);
        assertThat(solution).isEqualTo(result);
    }

    @Test
    @DisplayName("두 개 뽑아서 더한거 출력")
    void test1() {
        int a = 2;
        int b = 1;
        int result = p68644.plus(a, b);
        assertThat(result).isEqualTo(a + b);
    }

}
/*
1. 문제 이해

(1) 정수 배열 numbers
(2) 서로다른 인덱스 두개의 수를 뽑아 더해서 만들 수 있는 모든수를
(3) 오름차순으로 리턴해라


2. 예시

3. 구현

(1) 걍 이중포문...

4. 의문/주의
 */