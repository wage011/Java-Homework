public class nizhihuan{
    public static void main(String[] args) {
        // 对应题目中的 (2, 5, 4, 3, 1)
        int[] sigma = {2, 5, 4, 3, 1};

        System.out.print("原置换: ");
        printArray(sigma);
        int n = sigma.length;
        for (int i = 0; i < n; i++) {
            while (sigma[i] != i + 1) {
                int targetIndex = sigma[i] - 1;
                int temp = sigma[i];
                sigma[i] = sigma[targetIndex];
                sigma[targetIndex] = temp;
            }
        }

        System.out.print("逆置换: ");
        printArray(sigma);
    }

    private static void printArray(int[] arr) {
        System.out.print("(");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println(")");
    }
}