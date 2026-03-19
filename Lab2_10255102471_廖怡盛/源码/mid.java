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
