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
    
