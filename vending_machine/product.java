public class product {
  int price = 150;
  int payment;

  public int payment_amount(int payment){

      System.out.println("お金を入金してください");
      while(true){
        System.out.println("お金が足りません");
        int money = new java.util.Scanner(System.in).nextInt();
        payment += money;
        System.out.println("只今の入金金額" + payment);
        if(payment > price) {
          System.out.println("お買い上げありがとうございました");
          break;
        }
      }

    return price;
  }
}
