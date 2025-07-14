package neet_code.sliding_window;

public class _76_MinimumWindowSubstring {
    public static void main(String[] args) {

    }

    //    Given two strings s and t of lengths m and n respectively, return the minimum
    //    window substring of s such that every character in t (including duplicates)
    //    is included in the window. If there is no such substring,
    //    return the empty string "".
    public static String minWindow(String s, String t) {
        // s & t contain uppercase & lowercase letters
        // char code ranging from 65 (A) -> 122 (z) = 58 chars
        // (including irrelevant chars from 91-96)
        int[] frequency = new int[58];
        int left = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int minStartIndex = -1;
        int charsNeeded = t.length();

        for (char c : t.toCharArray()) {
            frequency[c - 'A']++;
        }

        for (int right = 0; right < s.length(); right++) {
            if (frequency[s.charAt(right) - 'A'] > 0) {
                charsNeeded--;
            }

            if (charsNeeded == 0) {
                // increment left to the nearest index at which the character appears in t
                // while keeping charsNeeded = 0
                while (frequency[s.charAt(left) - 'A'] < 0) {
                    frequency[s.charAt(left) - 'A']++;
                    left++;
                }

                if (right - left + 1 < minWindowLength) {
                    minWindowLength = right - left + 1;
                    minStartIndex = left;
                }

                // increment left to the nearest index at which the character appears in t
                // until charsNeeded = 1
                while (charsNeeded == 0) {
                    frequency[s.charAt(left) - 'A']++;
                    if (frequency[s.charAt(left) - 'A'] > 0) charsNeeded++;
                    left++;
                }
            }

            frequency[s.charAt(right) - 'A']--;
        }

        return minStartIndex == -1 ? "" : s.substring(minStartIndex, minStartIndex + minWindowLength);
    }
}
