package ArraysStrings;

public class ArrayStringZeroMatrix {

    public static int[][] zeroMatrix(int[][] matrix) {
        int numberOfRow = matrix.length;
        int numberOfColumn = matrix[0].length;

        boolean[] zeroRow = new boolean[numberOfRow];
        boolean[] zeroColumn = new boolean[numberOfColumn];

        printMatrix(matrix);
        for (int i = 0; i < numberOfColumn; i ++) {
            for (int j =0; j < numberOfRow; j++){
                if (matrix[i][j]==0) {
                    zeroRow[i] = true;
                    zeroColumn[j] = true;
                }
            }
        }

        for (int i = 0; i < numberOfRow; i++){
            if (zeroRow[i]){
                nullifyRow(matrix, i);
            }
        }

        for (int i = 0; i < numberOfColumn; i++){
            if (zeroColumn[i]){
                nullifyColumn(matrix, i);
            }
        }
        printMatrix(matrix);
        return matrix;
    }

    private static void nullifyRow(int[][] matrix, int index){
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[index][i] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int index){
        for (int i = 0; i < matrix.length; i ++){
            matrix[i][index] = 0;
        }
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("ArrayStringZeroMatrix");
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
