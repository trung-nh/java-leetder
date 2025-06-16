package neet_code.two_pointers;

public class _125_ValidPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        String string = s.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        return string.contentEquals(new StringBuilder(string).reverse());
    }

    public boolean isPalindrome_(String s) {
        String string = s.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        return string.contentEquals(new StringBuilder(string).reverse());
    }
}
