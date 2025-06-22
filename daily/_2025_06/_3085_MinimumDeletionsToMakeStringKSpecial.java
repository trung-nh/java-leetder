package daily._2025_06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _3085_MinimumDeletionsToMakeStringKSpecial {
    public static void main(String[] args) {
        minimumDeletions("aaabaaa", 2);
    }

    public static int minimumDeletions_(String word, int k) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int value : freq) {
            if (value == 0) continue;
            int freqEle = value;
            int max = freqEle + k;
            int ans = 0;
            for (int i : freq) {
                if (i < freqEle) ans = ans + i;
                else if (i > max) ans = ans + i - max;
            }
            min = Math.min(min, ans);
        }
        return min;
    }

    public static int minimumDeletions(String word, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int result = Integer.MAX_VALUE;

        for (char character : word.toCharArray()) {
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        int[] frequencyArray = map.values().stream().mapToInt(Integer::intValue).toArray();
        int length = frequencyArray.length;
        Arrays.sort(frequencyArray);
        int maxStartRange = frequencyArray[length - 1] - k;
        if (maxStartRange <= frequencyArray[0]) {
            return 0;
        }

        for (int i = 0; i < length; i++) {
            int minFrequency = frequencyArray[i];
            int maxFrequency = minFrequency + k;
            int deletionCount = 0;
            int right = i + 1;

            // handle the left section of the frequency range
            for (int left = i - 1; left >= 0; left--) {
                deletionCount += frequencyArray[left];
            }

            // handle the right section of the frequency range
            while (right < length && frequencyArray[right] < maxFrequency) {
                right++;
            }
            for (; right < length; right++) {
                deletionCount += frequencyArray[right] - maxFrequency;
            }

            result = Math.min(result, deletionCount);
        }
        System.out.println(result);
        return result;
    }
}
