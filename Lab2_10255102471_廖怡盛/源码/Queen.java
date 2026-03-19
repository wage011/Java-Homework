public class Queen{

    public static void main(String[] args) {
        int[] board = {5, 2, 4, 1, 3};

        boolean isSafe = checkSafety(board);
        System.out.println("棋盘是否安全: " + isSafe);
    }

    public static boolean checkSafety(int[] p) {
        int n = p.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (p[i] == p[j]) {
                    return false;
                }
                if (Math.abs(i - j) == Math.abs(p[i] - p[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}