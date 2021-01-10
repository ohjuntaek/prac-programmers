import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/60058">문제 보기</a>
 */
public class P60058_괄호변환 {
    public String solution(String p) {
        return process(p);
    }

    public String process(String str) {
        if (str.isEmpty()) {
            return str;
        }

        if (isRightStr(str)) {
            return str;
        }

        String u = null;
        String v = null;
        for (int i = 2; i <= str.length(); i+=2) {
            String tempU = str.substring(0, i);
            String tempV = str.substring(i);
            if (isBalancedStr(tempU)) {
                u = tempU;
                v = tempV;
                break;
            }
        }

        if (isRightStr(u)) {
            String process = process(v);
            return u + process;
        }

        StringBuilder t = new StringBuilder("(" + process(v) + ")");
        String[] splitU = u.split("");
        for (int i = 1; i < splitU.length - 1; i++) {
            if (splitU[i].equals("(")) {
                t.append(")");
            } else {
                t.append("(");
            }
        }

        return t.toString();
    }

    public List<String> splitToTwoBalancedStr(String w) {
        return null;
    }

    public boolean isBalancedStr(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        int open = 0;
        int close = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
        }
        return open == close;
    }

    public boolean isRightStr(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        int top = 0;
        String[] split = str.split("");
        for (String s : split) {
            if (s.equals("(")) {
                top++;
            } else {
                top--;
                if (top < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
