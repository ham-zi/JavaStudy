package roof;

public class RandomNumWithWhileExample {

    public static void main(String[] args) {


        int randomNum1=0;
        int randomNum2=0;
        while (randomNum1 + randomNum2 != 5){

            randomNum1 = (int) (Math.random() * 6) + 1;
            randomNum2 = (int) (Math.random() * 6) + 1;

            System.out.println("("+randomNum1+","+randomNum2+")"  );
        }

        System.out.println("-------------------------");
        int randomNum3=0;
        int randomNum4=0;
        while (true){

            randomNum3 = (int) (Math.random() * 6) + 1;
            randomNum4 = (int) (Math.random() * 6) + 1;
            System.out.println("("+randomNum3+","+randomNum4+")"  );

            if (randomNum3+randomNum4==5) {
                break;
            }
        }

        System.out.println("------------------------");

        int coin=1;
        int randomNum5;
        int randomNum6;
        for(;coin<=10;coin++){
            randomNum5 = (int) (Math.random() * 6) +1;
            randomNum6 = (int) (Math.random() * 6) +1;
            System.out.printf("주사위(%1$d,%2$d)입니다.\n",randomNum5,randomNum6);

            if(randomNum5+randomNum6==4){
                System.out.println("합이 4가 되어 성공하였습니다.");
                System.out.println("남은 coin:"+coin);
                break;
            }
            }
        if( coin == 11 ) {
            System.out.println("실패입니다.");
        }

    }
}
