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
