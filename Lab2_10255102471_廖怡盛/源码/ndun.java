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
