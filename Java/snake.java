public class snake{
    public static int[][] Snake(int n) {
        if (n <= 0) return new int[0][0];

        int[][] matrix = new int[n][n];
        int num = 1; 
        int top = 0, bottom = n - 1; 
        int left = 0, right = n - 1;
        while (num <= n * n) {
            for (int col = left; col <= right; col++) {
                matrix[top][col] = num++;
            }
            top++; 
            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = num++;
            }
            right--; 
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    matrix[bottom][col] = num++;
                }
                bottom--; 
            }
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    matrix[row][left] = num++;
                }
                left++;
            }
        }

        return matrix;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[][] result =Snake(n);
        for (int[] row : result) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
    }
}