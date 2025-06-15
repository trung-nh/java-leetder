package daily._2025_06;

import javax.sound.midi.SoundbankResource;

public class _1432_MaxDifferenceYouCanGetFromChangingAnInteger {
    public static void main(String[] args) {
        maxDiff(1101057);
    }

    public static int maxDiff(int num) {
        StringBuffer minString = new StringBuffer(String.valueOf(num));
        StringBuffer maxString = new StringBuffer(String.valueOf(num));
        int length = minString.length();

        // handle max
        for (int i = 0; i < length; i++) {
            char digit = maxString.charAt(i);
            if (digit != '9') {
                replaceDigit(maxString, digit, '9');
                break;
            }
        }

        //handle min
        for (int i = 0; i < length; i++) {
            char digit = minString.charAt(i);
            if (i == 0) {
                if (digit != '1') {
                    replaceDigit(minString, digit, '1');
                    break;
                }
            } else {
                if (digit != minString.charAt(0) && digit != '0') {
                    replaceDigit(minString, digit, '0');
                    break;
                }
            }
        }
        return Integer.parseInt(String.valueOf(maxString)) - Integer.parseInt(String.valueOf(minString));
    }

    private static void replaceDigit(StringBuffer string, char replacedDigit, char replacedWith) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == replacedDigit) {
                string.setCharAt(i, replacedWith);
            }
        }
    }
}
