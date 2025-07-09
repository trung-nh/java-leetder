package daily._2025_07;

public class _3439_RescheduleMeetingsForMaximumFreeTimeI {
    public static void main(String[] args) {

    }

    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int eventCount = startTime.length;
        int window = 0;
        int result = 0;

        for (int i = 0; i < eventCount; i++) {
            window += endTime[i] - startTime[i];

            // left is the start time of the first free time period in the window
            int left = i <= k - 1 ? 0 : endTime[i - k];
            // right is the end time of the last free time period in the window
            int right = i == eventCount - 1 ? eventTime : startTime[i + 1];
            result = Math.max(result, right - left - window);

            if (i >= k - 1) {
                window -= endTime[i - k + 1] - startTime[i - k + 1];
            }
        }

        return result;
    }

}
