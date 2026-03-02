package method;

import java.util.List;

public class MethodOverloding {

    double areaRectangle(double width) {
        return width * width;
    }

    double areaRectangle(double width, double height) {
        return width * height;
    }

    int areaRectangle(int width, int height) { //반환타입이 변경되어도 가능
        return  width * height;
    }

    public static void main(String[] args) {
        MethodOverloding area = new MethodOverloding();

        double area1 = area.areaRectangle(10);
        double area2 = area.areaRectangle(10,12);
        int area3 = area.areaRectangle(11,13);
        System.out.println("area1 = " + area1);
        System.out.println("area2 = " + area2);
        System.out.println("area3 = " + area3);
    }
}