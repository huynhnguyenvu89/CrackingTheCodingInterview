import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of a StringBuilder
 * - Use a char array would result in better performance and efficiency
 * - Use List<Character> is very inefficient, a char only costs 2 bytes, while a Character can take up to 16 bytes as
 * an Object
 * - Avoid using toCharArray() on the input String, because it only creates an extra and unused array
 * - Use charAt() instead of converting String to char[]
 *
 */
public class StringBuilder {
    private char[] buffer;
    private int crrIndex;

    public StringBuilder(){
        initialize();
    }

    public StringBuilder(String initialInput){
        initialize();
        append(initialInput);
    }

    public void append(String input){
        if (input == null){
            throw new NullPointerException("Input must not be null");
        }
        if (input.length() == 0) {
            return;
        }
        //If array is overflown, resize the array
        if ((input.length() + crrIndex) > buffer.length){
            buffer = Arrays.copyOf(buffer, 2 * (input.length() + crrIndex));
        }
        for (int i = 0; i < input.length(); i ++){
            buffer[crrIndex ++] = input.charAt(i);
        }
    }

    @Override
    public String toString() {
        return new String(buffer);
    }

    private void initialize(){
        buffer = new char[10];
        crrIndex = 0;
    }
}
