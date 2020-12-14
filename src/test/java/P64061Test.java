import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class P64061Test {
    int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}
    };

    int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
    P64061 p64061 = new P64061();

    @Test
    void test() {
        int result = p64061.solution(board, moves);

        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("인형을 뽑아서 바구니에 담는다.")
    void test1() {
        List<Integer> basket = new ArrayList<>();
        int pung = p64061.pick(basket, 0, board, moves);
        assertThat(basket.get(0)).isEqualTo(4);
    }

    @Test
    @DisplayName("바구니에 연속된 같은게 있으면 없앤다.")
    void test2() {
        List<Integer> basket = new ArrayList<>();
        p64061.pick(basket, 0, board, moves);// 1
        p64061.pick(basket, 1, board, moves);// 5
        p64061.pick(basket, 2, board, moves); // 3
        int pung = p64061.pick(basket, 3, board, moves);// 5 => 펑

        assertThat(pung).isEqualTo(2);
    }
}
/*
1. 문제이해

(1) 인형뽑기 게임이다. (당연히 위에껄 뽑는다.)
(2) 인형 N*N, 바구니는 스택
(3) 같은 모양의 인형 두개가 바구니에 연속해서 쌓이면 두 인형은 사라지게 된다.
(4) board : 인형보드, moves : 크레인 작동시킨 위치
(5) 크레인을 모두 작동시킨후 터트려져 사라진 인형의 개수를 리턴하라.
(6) board 는 5*5 이상 30*30 이하이다.
(7) board의 각 칸에는 0~100 인 정수가 있다. 0 은 빈칸이고 1 ~ 100은 각 인형이다.
(8) moves 배열의 크기는 1이상 1000 이하이다
(9) moves 원소의 값은 1 이상이며  board의 가로 크기 이하이다.

2. 예시


3. 구현

4. 주의/의문
- 두개 이상 연속인 경우는 당연히 없겠지?


 */