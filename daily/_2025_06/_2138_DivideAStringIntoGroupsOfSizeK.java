package daily._2025_06;

public class _2138_DivideAStringIntoGroupsOfSizeK {
    public static void main(String[] args) {

    }

    public String[] divideString(String s, int k, char fill) {
        int length = s.length();
        int groupCount = (int) Math.ceil((double) length / k);
        String[] result = new String[groupCount];

        for (int i = 0; i < groupCount; i++) {
            if (i == groupCount - 1 && length / k < groupCount) {
                int fillCount = groupCount * k - length;
                result[i] = s.substring(i * k);
                result[i] += String.valueOf(fill).repeat(fillCount);
            } else {
                result[i] = s.substring(i * k, k * (i + 1));
            }
        }

        return result;
    }
}
