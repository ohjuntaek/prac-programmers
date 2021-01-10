import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 1. 균형 잡힌 괄호 문자열 : ( 와 ) 의 개수가 같다.
 * 2. 올바른 괄호 문자열 : ( 와 ) 의 짝도 모두 맞다.
 * 3. 균형 잡힌 괄호 문자열 -> 올바른 괄호 문자열 과정
 * => 테케3 참조
 */
class P60058_괄호변환Test {
    P60058_괄호변환 P = new P60058_괄호변환();

    @Test
    @DisplayName("균형잡힌 문자열/올바른 문자열 판단")
    void test1() {
        String str = "(()))("; // 균형잡힌 괄호 문자열이고, 올바른 괄호 문자열은 아니다.

        assertThat(P.isBalancedStr(str)).isTrue();
        assertThat(P.isRightStr(str)).isFalse();
    }

    @Test
    @DisplayName("균형잡힌 문자열/올바른 문자열 판단2")
    void test2() {
        String str = "(())()"; // 균형잡힌 괄호 문자열이고, 올바른 괄호 문자열이다.

        assertThat(P.isBalancedStr(str)).isTrue();
        assertThat(P.isRightStr(str)).isTrue();
    }

    @Test
    @Disabled
    @DisplayName("균형 잡힌 괄호 문자열 -> 올바른 괄호 문자열 과정 - 1")
    void test3() {
        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        // 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며,
        // v는 빈 문자열이 될 수 있습니다.

        String w = "(()))(";

        List<String> twoBalancedStr = P.splitToTwoBalancedStr(w);
        String u = twoBalancedStr.get(0);
        String v = twoBalancedStr.get(1);

        assertThat(P.isBalancedStr(u)).isTrue();
    }

    @Test
    void test3_1() {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        String empty = "";

        assertThat(P.process(empty)).isEqualTo("");
    }

    @Test
    void test4() {
        String solution = P.solution("(()())()");
        assertThat(solution).isEqualTo("(()())()");
    }

    @Test
    void test5() {
        String solution = P.solution(")(");
        assertThat(solution).isEqualTo("()");
    }

    @Test
    void test6() {
        assertThat(P.solution("()))((()")).isEqualTo("()(())()");
    }

    @Test
    void subStringTest() {
        String a = "abc";
        String substring = a.substring(0, 3);
        System.out.println(substring);
    }


}