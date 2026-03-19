import java.util.ArrayList;
import java.util.List;

public class N{

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]); // 示例 N
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[N + 1];

        generate(1, N, path, used);
    }

    private static void generate(int  n,int N, List<Integer> path, boolean[] used) {
        if (path.size() == N) {
            System.out.println(path);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                path.add(i);
                used[i] = true;
                generate(i + 1, N, path, used);
                // 回溯
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}