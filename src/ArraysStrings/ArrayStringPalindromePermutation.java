package ArraysStrings; /**
 Given a string, write a function to check if it is a permutation of a palindrome.
 A palindrome is a word or phrase that is the same forwards and backwards.
 A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 */

/**
 * This is an anagram problem, where we were to find out if any of the input's permutation is a palindrome.
 * To be a palindrome, the word must have an even count for each character, or there is only 1 odd
 * character count.
 */
public class ArrayStringPalindromePermutation {
    /**
     * Assuming ASCII string only
     * @param input
     * @return
     */
    public boolean hasPalindromePermutation(String input){
        int[] characters = new int[128];

        for (int i = 0; i < input.toCharArray().length; i ++){
            char c = input.charAt(i);
            if (c != ' '){
                characters[c]++;
            }
        }

        boolean foundOdd = false;
        for (int i = 0; i < characters.length; i ++) {
            if (characters[i]%2 == 1){
                if (foundOdd)
                    return false;
                foundOdd = true;
            }
        }
        return true;
    }

    public boolean isPalindromePermutation(String input){
        int[] table = buildCharacterFrequencyTable(input);
        return checkMaxOneOdd(table);
    }

    private boolean checkMaxOneOdd(int[] input) {
        boolean foundOdd = false;

        for (int count : input) {
            if (count % 2 == 1) {
                if (foundOdd)
                    return false;
                foundOdd = true;
            }
        }
        return true;
    }

    private int[] buildCharacterFrequencyTable(String input){
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (int i = 0; i < input.length(); i ++) {
            int x = getCharNumber(input.charAt(i));
            if (x != -1)
                table[x]++;
        }
        return table;
    }

    private int getCharNumber(Character c){
        int zIndex = Character.getNumericValue('z');
        int aIndex = Character.getNumericValue('a');
        int cIndex = Character.getNumericValue(c);
        if (cIndex >= aIndex && cIndex <= zIndex)
            return cIndex - aIndex;
        return -1;
    }

    public boolean isPalindromePermutation2(String input) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        int oddCount = 0;

        for (char c : input.toCharArray()){
            int cIndex = getCharNumber(c);
            if (cIndex != -1) {
                table[cIndex]++;
                if (table[cIndex] % 2 == 1){
                    oddCount ++;
                } else {
                    oddCount --;
                }
            }
        }
        return oddCount <= 1;
    }
}
