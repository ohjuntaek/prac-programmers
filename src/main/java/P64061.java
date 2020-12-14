import java.util.ArrayList;
import java.util.List;

/**
 * 크레인 인형뽑기 게임
 *
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/64061?language=java"></a>
 */
public class P64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> basket = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
            answer += pick(basket, i, board, moves);
        }
        return answer;
    }

    public int pick(List<Integer> basket, int moveIdx, int[][] board, int[] moves) {
        int col = moves[moveIdx] - 1;
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == 0) {
                continue;
            }
//            System.out.println("row = " + row);
//            System.out.println("col = " + col);
            System.out.println();
            basket.add(board[row][col]);
            board[row][col] = 0;
            break;
        }

        if (basket.size() < 2) {
            return 0;
        }
        Integer top = basket.get(basket.size() - 1);
        Integer topLow = basket.get(basket.size() - 2);
        if (top.equals(topLow)) {
            basket.remove(basket.size() - 1);
            basket.remove(basket.size() - 1);
            return 2;
        }
        return 0;
    }
}
