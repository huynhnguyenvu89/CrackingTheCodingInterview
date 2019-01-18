package ArraysStrings;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class ArrayStringRotateMatrix {
    public static int[][] rotate(int[][] matrix){
        //Make sure it's NxN matrix
        if (matrix.length == 0 || matrix.length != matrix[0].length)
            return matrix;

        int n = matrix.length;

        for (int layer = 0; layer < n/2; layer ++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = last - i;
                int top = matrix[last][last - offset];
                matrix[last][last - offset]= matrix[last - offset][last];
                matrix[last - offset][last] = matrix[last - offset][last];
                matrix[last - offset][last] = matrix[first][i];
                matrix[first][i] = top;
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("ArrayStringCompression");
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+ ", ");
                if (j == 6){
                    System.out.print("\n");
                }
            }
        }
    }
}
