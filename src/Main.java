import ArraysStrings.*;
import ArraysStrings.StringBuilder;

public class Main {

    public static void main(String[] args) {
        ArrayStringOneAway oneAway = new ArrayStringOneAway();
        System.out.println("One edit away " + oneAway.oneEditAway("pale,", "ple"));
        System.out.println("One edit away " + oneAway.oneEditAway("pales,", "pale"));
        System.out.println("One edit away " + oneAway.oneEditAway("pale,", "bale"));
        System.out.println("One edit away " + oneAway.oneEditAway("pale,", "bae"));

        ArrayStringPalindromePermutation arrStrPM = new ArrayStringPalindromePermutation();
        System.out.println("hasPalindromePermutation: " + arrStrPM.hasPalindromePermutation("tact coa"));
        System.out.println("hasPalindromePermutation: " + arrStrPM.hasPalindromePermutation("tactcoapapa"));
        System.out.println("hasPalindromePermutation: " + arrStrPM.hasPalindromePermutation("I am a God"));
        System.out.println("isPalindromePermutation: " + arrStrPM.isPalindromePermutation("tact coa"));
        System.out.println("isPalindromePermutation: " + arrStrPM.isPalindromePermutation("tactcoapapa"));
        System.out.println("isPalindromePermutation: " + arrStrPM.isPalindromePermutation("I am a God"));
        System.out.println("isPalindromePermutation2: " + arrStrPM.isPalindromePermutation2("tact coa"));
        System.out.println("isPalindromePermutation2: " + arrStrPM.isPalindromePermutation2("tactcoapapa"));
        System.out.println("isPalindromePermutation2: " + arrStrPM.isPalindromePermutation2("I am a God"));

        System.out.println("Check URLify: " + ArrayStringURLify.urlify("I am a God"));
        System.out.println("Check URLify: " + ArrayStringURLify.urlify("Say my name ! ! ! "));

        //Implementation of ArraysStrings.StringBuilder
        StringBuilder stringBuilder = new StringBuilder("Hello world! \n");
        stringBuilder.append("This is a ");
        stringBuilder.append("ArraysStrings.StringBuilder implementation in Java");
        System.out.println(stringBuilder.toString());

        //Implementation of a ArraysStrings.HashTable
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.add("key 1", "value 1");
        hashTable.add("key 2", "value 2");
        hashTable.add("key 3", "value 3");
        hashTable.add("key 4", "value 4");
        hashTable.add("key 5", "value 5");
        hashTable.add("key 5", "value 6");
        hashTable.add("key 1", "value 10");
        System.out.println("ArraysStrings.HashTable size: " + hashTable.size());
        System.out.println(hashTable.get("key 5"));
        System.out.println(hashTable.remove("key 1"));
        System.out.println(hashTable.remove("key 1"));
        System.out.println(hashTable.size());
        System.out.println(hashTable.isEmpty());

        //Implementation of an ArraysStrings.ArrayList
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("Array ");
        arrayList.add(0, "List ");
        arrayList.add("Implementation");
        System.out.println("ArraysStrings.ArrayList " + arrayList.get(1) + " " + arrayList.size());

        //String permutation
        ArrayStringCheckPermutation permutation = new ArrayStringCheckPermutation();
        permutation.checkPermutation("this is a string", "thi sis astri ng");

    }
}
