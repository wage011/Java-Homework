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
