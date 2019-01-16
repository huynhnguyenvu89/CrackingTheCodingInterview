public class ArrayStringURLify {

    public static String urlify(String input) {
        int spaceCount = 0;
        char[] inputArray = input.toCharArray();

        //Count space in String
        for (int i = 0; i < inputArray.length; i ++){
            if (inputArray[i] == ' ')
                spaceCount++;
        }

        //If no space, return as is
        if (spaceCount == 0)
            return input;

        int newLength = inputArray.length + spaceCount * 2;
        char[] urlified = new char[newLength];
        for (int i = inputArray.length - 1; i >= 0; i-- ) {
            char c = inputArray[i];
            if (c == ' '){
                urlified[newLength - 1] = '0';
                urlified[newLength - 2] = '2';
                urlified[newLength - 3] = '%';
                newLength -= 3;
            } else {
                urlified[--newLength] = c;
            }
        }
        return new String(urlified);
    }
}
