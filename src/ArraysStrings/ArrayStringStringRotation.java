package ArraysStrings;

public class ArrayStringStringRotation {

    public static boolean isRotation(String s1, String s2) {
        int n = s1.length();
        if (n == s2.length() && n > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    private static boolean isSubstring(String s1, String s2) {
        int difference  = s1.length() - s2.length();
        for (int i = 0; i < difference; i ++){
            String subString = s1.substring(i, difference + i);
            if (subString.equalsIgnoreCase(s2))
                return true;
        }
        return false;
    }
}
