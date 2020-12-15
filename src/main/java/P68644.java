import java.util.*;

/**
 * 두 개 뽑아서 더하기
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/68644">링크</a>
 */
public class P68644 {
    public int[] solution(int[] numbers) {
        Set<Integer> a = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int plus = plus(numbers[i], numbers[j]);
                a.add(plus);
            }
        }
        List<Integer> aa = new ArrayList<>(a);
        Collections.sort(aa);
        int[] toArray = aa.stream().mapToInt(e -> e).toArray();
        return toArray;
    }

    public int plus(int a, int b) {
        return a + b;
    }
}
