package neet_code.sliding_window;

public class _567_PermutationInString {
    public static void main(String[] args) {

    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] frequency = new int[26];
        int left = 0;

        for (char c : s1.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (int right = 0; right < s2.length(); right++) {
            if (frequency[right] == 0) {
                while (left <= right) {
                    frequency[s2.charAt(left) - 'a']++;
                    left++;
                }
            }
            frequency[right]--;
        }

        return false;
    }
}
