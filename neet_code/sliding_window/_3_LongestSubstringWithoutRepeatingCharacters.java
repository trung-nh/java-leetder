package neet_code.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class _3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        int[] lastSeen = new int[128];

        int left = 0;
        for (int right = 0; right < n; right++) {
            char current = s.charAt(right);
            left = Math.max(left, lastSeen[current]);
            result = Math.max(result, right - left + 1);
            lastSeen[current] = right + 1;
        }

        return result;
    }

    public static int lengthOfLongestSubstring_(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        char[] chars = s.toCharArray();
        int result = 0;

        for (int right = 0; right < chars.length; right++) {
            if (set.contains(chars[right])) {
                while (left < right) {
                    set.remove(chars[left]);
                    if (chars[left] == chars[right]) {
                        left++;
                        break;
                    }
                    left++;
                }
            }

            set.add(chars[right]);

            if (right - left + 1 > result) {
                result = right - left + 1;
            }
        }

        return result;
    }
}
