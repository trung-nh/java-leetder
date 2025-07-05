package daily._2025_07;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class _1394_FindLuckyIntegerInAnArray {
    public static void main(String[] args) {

    }

    public int findLucky(int[] arr) {
        AtomicInteger luckyNumber = new AtomicInteger(-1);
        AtomicInteger maxFrequency = new AtomicInteger();
        Map<Integer, Integer> fMap = new HashMap<>();

        for (int num : arr) {
            int currentFrequency = fMap.getOrDefault(num, 0) + 1;
            fMap.put(num, currentFrequency);
        }

        fMap.forEach((num, freq) -> {
            if (Objects.equals(num, freq)){
                if(freq > maxFrequency.get()) {
                    maxFrequency.set(freq);
                }
                if (freq == maxFrequency.get()) {
                    luckyNumber.set(Math.max(luckyNumber.get(), num));
                }
            }

        });

        return luckyNumber.get();
    }
}
