package neet_code.two_pointers;

public class _125_ValidPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        char[] charArray = s.toLowerCase().trim().toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            while (!Character.isLetterOrDigit(charArray[left]) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(charArray[right]) && left < right) {
                right--;
            }
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome_(String s) {
        String string = s.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        return string.contentEquals(new StringBuilder(string).reverse());
    }

    // fastest : Character.isLetterOrDigit()
    // faster
    private static boolean isAlphanumeric(char c) {
        return (
                c - '0' >= 0 && '9' - c >= 0)
                || (c - 'a' >= 0 && 'z' - c >= 0)
                || (c - 'A' >= 0 && 'Z' - c >= 0
        );
    }

    // slower
    private static boolean isAlphanumeric_(char c) {
        return String.valueOf(c).matches("[a-zA-Z0-9]");
    }
}
