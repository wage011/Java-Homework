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
