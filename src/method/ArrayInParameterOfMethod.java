package method;

public class ArrayInParameterOfMethod {

    public static class Computer {

        int sum(int[] values) {
            int sum= 0;
            for(int i : values) {
                sum += i;
            }
            return sum;
        }


    public static void main(String[] args) {

        int[] numbers = { 10, 11 , 14 , 15, 19 };

        Computer computer = new Computer();
        System.out.println(computer.sum(numbers));
    }

}}
