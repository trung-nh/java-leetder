package neet_code.sliding_window;

public class _424_LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {

    }

    public static int characterReplacement(String s, int k) {
        int[] frequency = new int[26];
        char[] chars = s.toCharArray();
        int left = 0;
        int result = 1;
        int mostFrequentCharCount = 0;

        // maintain a sliding window and the highest frequency of a character within it
        for (int right = 0; right < chars.length; right++) {
            frequency[chars[right] - 'A']++;
            mostFrequentCharCount = Math.max(mostFrequentCharCount, frequency[chars[right] - 'A']);

            if (right - left - mostFrequentCharCount + 1 > k) {
                frequency[chars[left] - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
