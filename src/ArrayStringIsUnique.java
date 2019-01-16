/**
 * Implement an algorithm to determine if a string has all unique character
 * What if you cannot use additional data structure
 */
public class ArrayStringIsUnique {
    /**
     * Assuming the input is an ASCII string
     * @param input
     * @return
     */
    private boolean isUnique(String input){
        if (input.length() > 128)
            return false;

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i);
            if (charSet[val])
                return false;
            charSet[val] = true;
        }
        return false;
    }
}
