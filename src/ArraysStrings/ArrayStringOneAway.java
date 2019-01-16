package ArraysStrings;

/**
 * There are 3 types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
 * Given 2 strings, write a function to check if they are one edit (or zero edits) away.
 */
public class ArrayStringOneAway {

    /**
     * Insert a character in reverse of remove a character
     * We can tell if the 2 strings have been inserted, removed or replaced a character by counting their length
     */
    public boolean oneEditAway(String s1, String s2){
        if (s1.length() == s2.length())
            return oneEditReplace(s1, s2);
        if (s1.length() + 1 == s2.length())
            return oneEditInsert(s1, s2);
        if (s1.length() - 1 == s2.length())
            return oneEditInsert(s2, s1);
        return false;
    }

    private boolean oneEditReplace(String s1, String s2){
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i ++){
            if (s1.charAt(i) != s2.charAt(i)){
                if (foundDifference)
                    return false;
                foundDifference = true;
            }
        }
        return true;
    }

    private boolean oneEditInsert(String s1, String s2){
        int index1 =0, index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()){
            if (s1.charAt(index1) != s2.charAt(index2)){
                if (index1 != index2)
                    return false;
                index2 ++;
            } else {
                index1 ++;
                index2 ++;
            }
        }
        return true;
    }
}
