package roof;

public class LoofInLoofExample {

    public static void main(String[] args) {

        for(int x=1;x<=10;x++){
            for(int y=1;y<=10;y++){
                if(4*x + 5*y == 60){
                    System.out.printf("해:(%1$d,%2$d)\n",x,y);
                }
            }
        }


        System.out.println("--------------");

        String space = " ";
        String star = "*";

        /*for(int i=1; i<=4; i++){
            for(int j=1; j<=4; j++){
                if(i==j || i>=j){
                    System.out.print(star);
                }
            }
            System.out.println();
            *
            **
            ***
            ****
        }*/

        for(int i=1; i<=4; i++){
            for(int j=4; j>=1; j--){
                if(i<j){
                    System.out.print(space);
                }

                if(i==j || i>=j){
                    System.out.print(star);
                }
            }
            System.out.println();
        }
        /*
           *
          **
         ***
        ****
*/



    }


}
