package ArraysStrings;

/**
 * String compression: Implement a method to perform basic string compression
 * using the counts of repeated characters.
 * For example: the string 'aabcccccaaa' would become a2b1c5a3.
 * If the "compressed" string would not become smaller than the original string,
 * your method should return the original string.
 * You can assume the string had only uppercase and lowercase letters (a-z)
 */
public class ArrayStringCompression {
    /**
     * Because the String consists of only repeated letters
     * @param input aabcccccaaa
     * @return
     */
    public static String compress(String input) {
        StringBuilder out = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < input.length(); i ++) {
            counter ++;
            System.out.println(i + "-" + input.charAt(i) + ": " + counter);
            if ((i + 1 == input.length()) || (input.charAt(i) != input.charAt(i + 1))){
                out.append(input.charAt(i) + "");
                out.append(counter + "");
                counter = 0;
            }
        }
        System.out.println("Check " + input + " " + out.toString());
        return out.toString().length() < input.length() ? out.toString() : input;
    }
}
