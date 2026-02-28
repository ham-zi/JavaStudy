package constructor;

public class ConstructorChainng {

    public static class Car {
        String model;
        String color;
        int maxSpeed;

        public Car ( String model) {
            this(model,"노랑색", 250);
        }

       public Car ( String model, String color) {
           this(model, color, 300);
       }

        public Car ( String model, String color, int maxSpeed ) {
            this.model = model;
            this.color = color;
            this.maxSpeed = maxSpeed;
        }
    }

    public static void main(String[] args) {

        Car car1 = new Car ( "승용차" );
        Car car2 = new Car ( "승용차", "검정색" );
        Car car3 = new Car ( "소형차", "빨강색", 170 );

        System.out.printf("car1 = %1$s, %2$s, %3$d\n",car1.model, car1.color, car1.maxSpeed);
        System.out.printf("car2 = %1$s, %2$s, %3$d\n",car2.model, car2.color, car2.maxSpeed);
        System.out.printf("car3 = %1$s, %2$s, %3$d\n",car3.model, car3.color, car3.maxSpeed);

    }

}
