import java.util.Scanner;
import java.util.Random;

class Main {
  public static void main(String[] args){
    int ans = new Random().nextInt(10) + 1;
    int count = 0;


    while(true){

          System.out.print("your guess?");
          int guess = new Scanner(System.in).nextInt();
          count++;

          if( ans == guess){
            System.out.println("OK!");
            break;
          } else if( ans > guess ) {
            System.out.println("The ans is higher");
          } else if( ans < guess) {
            System.out.println("The ans is lower");
          }
        }
  }
}
