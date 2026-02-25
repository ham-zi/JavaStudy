package operator;

public class FloatDoublePointComparisonExample {

    public static void main(String[] args) {

        int v1 = 1;
        double v2 = 1.0;
        System.out.println(v1 == v2);

        double v3 = 0.3;
        float v4 = 0.3f;
        System.out.println(v3 == v4);
        System.out.println((float) v3 == v4 );




    }
}
