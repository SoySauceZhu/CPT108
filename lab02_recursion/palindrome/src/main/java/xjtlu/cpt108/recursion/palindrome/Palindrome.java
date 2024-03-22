package xjtlu.cpt108.recursion.palindrome;

public class Palindrome {

    /**
     * Verify whether giving string is a palindrome
     *
     * @param str
     * @return boolean: true for palindrome, vice versa
     */
    public boolean verifyRecursive(String str) {
        str = formattedString(str);
        if (str.isEmpty()) return false;
        if (str.length() == 1) return true;
        if (str.length() == 2 && str.charAt(0) == str.charAt(1)) {
            return true;
        } else {
            return (str.charAt(0) == str.charAt(str.length() - 1))
                    && verifyRecursive(str.substring(1, str.length() - 1));
        }
    }


    /**
     * Verify whether giving string is a palindrome
     *
     * @param str
     * @return boolean: true for palindrome, vice versa
     */
    public boolean verifyIterative(String str) {
        str = formattedString(str);
        if (str.isEmpty()) return false;

        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) return false;
        }
        return true;
    }


    /**
     * Formatting the string by removing characters exclusive from letters and numbers, return the all-lowercase string
     *
     * @param str
     * @return string with only lowercase ascii letters and numbers
     */
    private static String formattedString(String str) {
        String[] strings = str.split("[^a-z0-9A-Z]");
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString().toLowerCase();
    }

    private static String betterFormatting(String str) {
        return str.replace("[^a-z0-9A-Z]", "").toLowerCase();
    }
}
