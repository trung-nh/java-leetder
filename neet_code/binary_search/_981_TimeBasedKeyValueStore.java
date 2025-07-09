package neet_code.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _981_TimeBasedKeyValueStore {
    Map<String, ArrayList<String>> map;

    public _981_TimeBasedKeyValueStore() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        ArrayList<String> timeValues = map.getOrDefault(key, new ArrayList<>());

        int[] indexToInsert = getIndex(timeValues, timestamp);

        String newValue = timestamp + "_" + value;
        if (indexToInsert[0] == 0) {
            timeValues.add(indexToInsert[1], newValue);
        } else {
            timeValues.set(indexToInsert[1], newValue);
        }
        map.put(key, timeValues);
    }

    public String get(String key, int timestamp) {
        ArrayList<String> timeValues = map.getOrDefault(key, new ArrayList<>());
        if (timeValues.isEmpty()) {
            return "";
        }

        int[] index = getIndex(timeValues, timestamp);

        if (index[0] == 0 && index[1] == 0) {
            return "";
        }

        String value = index[0] == 0 ? timeValues.get(index[1] - 1) : timeValues.get(index[1]);

        return value.split("_", 1)[1];
    }

    private int[] getIndex(ArrayList<String> values, int timestamp) {
        int left = 0;
        int right = values.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = Integer.parseInt(values.get(mid).split("_")[0]);

            if (midValue > timestamp) {
                right = mid - 1;
            } else if (midValue < timestamp) {
                left = mid + 1;
            } else {
                // found exact value
                return new int[]{1, mid};
            }
        }
        // return the index right after the nearest smaller value
        return new int[]{0, left};
    }
}
