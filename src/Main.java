import ArraysStrings.*;
import ArraysStrings.StringBuilder;

public class Main {
    public static void main(String[] args) {
        System.out.println("ArrayStringStringRotation " + ArrayStringStringRotation.isRotation("waterbottle", "erbottlewat"));

        int[][] matrix2 = new int[][]{
                {111, 112, 0, 114, 115, 116, 117},
                {221, 222, 223, 224, 0, 226, 227},
                {331, 332, 333, 334, 335, 0, 337},
                {441, 442, 443, 444, 445, 446, 447},
                {551, 552, 553, 554, 0, 556, 557},
                {661, 662, 663, 664, 665, 666, 667},
                {0, 772, 773, 774, 775, 776, 777},
        };
        ArrayStringZeroMatrix.zeroMatrix(matrix2);

        int[][] matrix = new int[][]{
                {111, 112, 113, 114, 115, 116, 117},
                {221, 222, 223, 224, 225, 226, 227},
                {331, 332, 333, 334, 335, 336, 337},
                {441, 442, 443, 444, 445, 446, 447},
                {551, 552, 553, 554, 555, 556, 557},
                {661, 662, 663, 664, 665, 666, 667},
                {771, 772, 773, 774, 775, 776, 777},
        };


        ArrayStringRotateMatrix.printMatrix(matrix);
        matrix = ArrayStringRotateMatrix.rotate(matrix);
        ArrayStringRotateMatrix.printMatrix(matrix);

        System.out.println("ArrayStringCompression " + ArrayStringCompression.compress("aabcccccaaa"));

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
