# Lab2_10255102471_廖怡盛

## 第一题
### 
(1)不能，java中true为小写，大写编译器会报错“找不到符号”;
(2)不能，java中int和布尔类型不能直接用==比较;
(3)不能，同上一小题;
(4)可以，String，2ab;将int类型的2自动转换为字符拼接;
(5)可以，String, 2.3ab;将double类型的2.3自动转为了字符串;
(6)可以，int，99;char类型运算时自动先提为int类型，a=97,2+97=99;
(7)不可以，int和String不能用*相互运算;
(8)可以，int，194;char类型的a提为int类型的97，再和2相乘;
(9)可以，double，2.0;自动将int类型的1转为double类型再相加;
(10)可以，int，0;int相除只保留整数部分;
(11)可以，double，0.333333;double与int相除结果为double类型;

## 第二题
1）2147483647
原因：直接输出变量a的值，a被初始化为Integer.MAX_VALUE，所以输出其本身
2）-2147483648
原因：int类型在Java中是32位有符号整数，取值范围是[-2147483648, 2147483647]
当a（最大值）加1时，会发生整数溢出，数值会循环到int类型的最小值-2147483648
3）-2147483645
原因：计算过程为2 - 2147483647 = -2147483645，这个结果在int的取值范围内，不会溢出，直接输出结果
4）-2147483645
原因：和第3条完全相同，结果一致
5）-2
原因：2 * 2147483647 = 4294967294，超出了int类型的最大值
根据补码溢出规则，计算结果对2^32取模后得到4294967294 - 2^32 = -2，所以输出-2。
6）-4
原因：4 * 2147483647 = 8589934588，同样超出int范围。
对2^32取模后得到8589934588 - 2*2^32 = -4

## 第三题
false,因为这个函数计算平方根浮点数计算存在微小误差，只能存储一个近似值;则两个平方根相乘近似2但不完全等于2;故==左右两边不相等，输出false;

## 第四题
```java
double r = Math.random();
public class juli {
    public static void main(String[] args) {
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        double dx = x2-x1;
        double dy = y2-y1;
        double result = Math.sqrt(dx*dx+dy*dy);
        System.out.println("距离"+result);
    }
}
```

## 第五题
```java
public class hanshu {
    public static void main(String[] args) {
        System.out.println("x\tlog(x)\tx\txlog(x)\tx^2\tx^3");
        for(int i=0;i<=11;i++){
            double x = Math.pow(2, i);
            double logX = Math.log(x);
            double xlogX = x*logX;
            double x2 = x*x;
            double x3 = x*x*x;
            
            System.out.printf("%.0f\t%.2f\t%.0f\t%.2f\t%.0f\t%.0f\n",x,logX,x,xlogX,x2,x3);
        }
    }
}
```

## 第六题
```java
public class ndun {
    public static double sqrt(double c){
        if(c<0)return Double.NaN;
        else{
            double x =c;
            double eps = 1e-10;
            while(Math.abs(x*x-c)>eps){
                x=(x+c/x)*(0.5);
            }
            return x;
        }
    }
    public static void main(String[] args) {
        double c = Double.parseDouble(args[0]);
        System.out.println("sqrt("+c+")="+sqrt(c));
    }
}
```

## 第七题
```java
public class mid {
    public static void main(String[] args) {
       int[] midnum = new int[5];
       for(int i=0;i<5;i++){
            midnum[i] = Integer.parseInt(args[i]);
       }
       java.util.Arrays.sort(midnum);
       System.out.println("中位数："+midnum[2]);
    }
}
```

## 第八题
false;两个数组引用地址并不相等

## 第九题
```java
public class Hadamard {
    public static int[][] Hn(int n){
        int size =(int)Math.pow(2, n-1);
        int[][] mat = new int[size][size];
        if(n==1){mat[0][0]=1;return mat;}
        int[][] sub = Hn(n-1);
        int subsize = size/2;
        for(int i=0;i<subsize;i++){
            for(int j=0;j<subsize;j++){
                mat[i][j]=sub[i][j];
                mat[i][j+subsize]=sub[i][j];
                mat[i+subsize][j]=sub[i][j];
                mat[i+subsize][j+subsize]=1-sub[i][j];
            }
        }
        return mat;
    }
    public static void main(String[] args) {
        int n=Integer.parseInt(args[0]);
        int[][] mat = Hn(n);
        for(int[] r:mat){
            for(int a:r){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
```

## 第十题
### 源码
```java
public class Alice {
    public static void main(String[] args) {
        int N=Integer.parseInt(args[0]);
        int[] A=new int[N];
        A[1]=1;
        int runs= 1000,allknow=0;
        for(int i=0;i<runs;i++){
            int count=0; 
            while (true) {
                int min = 2;
                int max = N-1;
                int randomNum = min + (int) (Math.random() * (max - min + 1));
                if(A[randomNum]!=1){A[randomNum]=1;count++;}
                else{break;}
            }
            if(count==N-1){allknow++;}
        }
        double p =(double)allknow/runs;
        double E =(N-1)*p;
        System.out.println("全员知晓的概率"+p+" ");
        System.out.println("期望"+E);
    }
}
```
### 补充说明
注意：N为不包括Alice但包括Bob的总人数，即参与传播八卦的总人数；
### 代码逻辑
通过for循环多次运行程序模拟传播，最后将全员知晓的次数除以总运行次数(runs)得到相应概率，再乘总人数得到期望；

## 第11题
```java
import java.util.ArrayList;
import java.util.List;

public class N{

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]); // 示例 N
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[N + 1];

        generate(1, N, path, used);
    }

    private static void generate(int n, int N, List<Integer> path, boolean[] used) {
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
```

## 第12题
```java
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
```

## 第13题
```java
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
```

## 第14题
```java
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
```

## 第15题
### 第一个源码
```java
import java.util.Arrays;

public class Statistic {

    public static double max(double[] a) {
        double maxVal = a[0];
        for (double v : a) {
            if (v > maxVal) maxVal = v;
        }
        return maxVal;
    }
    public static double min(double[] a) {
        double minVal = a[0];
        for (double v : a) {
            if (v < minVal) minVal = v;
        }
        return minVal;
    }
    public static double mean(double[] a) {
        double sum = 0;
        for (double v : a) {
            sum += v;
        }
        return sum / a.length;
    }
    public static double variance(double[] a) {
        double meanVal = mean(a);
        double sum = 0;
        for (double v : a) {
            sum += Math.pow(v - meanVal, 2);
        }
        return sum / a.length;
    }
    public static double select(double[] a, int k) {
        double[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(copy);
        return copy[copy.length - k];
    }
    public static int[] histogram(double[] a, double[] b) {
        int[] hist = new int[b.length - 1];
        for (double val : a) {
            for (int i = 0; i < b.length - 1; i++) {
                if (val >= b[i] && val < b[i + 1]) {
                    hist[i]++;
                    break;
                }
                if (i == b.length - 2 && val == b[i + 1]) {
                    hist[i]++;
                    break;
                }
            }
        }
        return hist;
    }
}
```
### 第二个源码
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Compute {
    public static double[] readDataFromFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            List<Double> list = new ArrayList<>();

            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    list.add(Double.valueOf(line));
                }
            }
            double[] data = new double[list.size()];
            for (int i = 0; i < list.size(); i++) {
                data[i] = list.get(i);
            }

            return data;
        }
    }
}
```

## 补充实验
```java
public class Test{
    public static void main(String[] args) {
        String fileName = "test.txt";

        System.out.println("=== 1. 开始写入文件 ===");
        FileIO.writeStringToFile("《老人与海》是海明威创作的中篇小说，首次出版于1952年。\n", fileName);
        FileIO.writeStringToFile("故事讲述了一位老渔夫圣地亚哥在海上与一条巨大的马林鱼搏斗的经历。\n", fileName);
        FileIO.writeStringToFile("The novel The Old Man and the Sea is based on a real story. After the end of world war I, Hemingway moved to Cuba, where\n", fileName);
        FileIO.writeStringToFile("in 1930, Hemingway was rescued by Fontes when his boat sank in a storm. From then on, Hemingway and Fontes formed a c\n", fileName);
        System.out.println("写入完成。");

        System.out.println("\n=== 2. 读取第5个字符 ===");
        char c = FileIO.getCharFromFile(5, fileName);
        System.out.println("第5个字符是: " + c);

        System.out.println("\n=== 3. 读取第3行 ===");
        String line3 = FileIO.getLineFromFile(2, fileName);
        System.out.println("第3行内容是: " + line3);

        System.out.println("\n=== 4. 读取所有行 ===");
        String[] allLines = FileIO.getAllLinesFromFile(fileName);
        System.out.println("文件所有行内容：");
        for (int i = 0; i < allLines.length; i++) {
            System.out.println("第 " + (i+1) + " 行: " + allLines[i]);
        }
    }
}
```

## git实验

### 1-3 
会新增了一个跟踪的文件；<<<<</====/>>>>均表示冲突标记
！[终端截图1]（1.png）
！[终端截图2]（2.png）
！[终端截图3]（4.png）
！[终端截图4]（5.png）
！[终端截图5]（6.png）
！[终端截图6]（7.png）

