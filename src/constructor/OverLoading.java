package constructor;

public class OverLoading {

    public static class Car {
        String model;
        String color;
        int maxSpeed;

        public Car(){ }
        public Car(String model){}
        public Car(String model, String color){}
        public Car(String model, String color, int maxSpeed){}
        // 매개 변수를 달리하는 생성자를 여러 개 선언하는 것을 말한다.
   /*
        public Car(String model){ // 매개 변수가 같으면, 필드의 초기화값이 달라도 컴파일에러
            this.model = model;
            String color = "레드";
        }
   */
    }
}
