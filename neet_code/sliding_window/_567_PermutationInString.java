package neet_code.sliding_window;

public class _567_PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("xyz", "xzxy"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] frequency = new int[26];
        int left = 0;

        for (char c : s1.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (int right = 0; right < s2.length(); right++) {
            if (frequency[s2.charAt(right) - 'a'] == 0) {
                while (left <= right) {
                    frequency[s2.charAt(left) - 'a']++;
                    left++;
                    if (s2.charAt(left - 1) == s2.charAt(right)) {
                        break;
                    }
                }
            }

            if (right - left + 1 == s1.length()) return true;

            frequency[s2.charAt(right) - 'a']--;
        }

        return false;
    }
}
