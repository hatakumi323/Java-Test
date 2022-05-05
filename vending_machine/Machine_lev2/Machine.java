package Machine_lev2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Machine {
  // メインロジック
  public static void main(String[] args) {
    // ①商品の初期化
    Map<String, Integer> items = initItems();

    // 購入最低金額の場合、追加入金
    int deposit = 0;
    Scanner scanner = new Scanner(System.in);
    do {
      // ②入金
      deposit = deposit(scanner, deposit);

      // ③金額チェック（最低購入金額）
    } while (!isMinSaleAmount(items, deposit));

    // ④商品選択
    Map<String, Integer> availablePurchases = selectItem(items, deposit);

    // ⑤販売
    String itemName = saleItem(scanner, availablePurchases);
    scanner.close();

    // ⑥課金機能
    charge(deposit, availablePurchases, itemName);
  }

  // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
  // 以下、メソッド分割
  // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

  // ①商品の初期化
  private static Map<String, Integer> initItems() {
    Map<String, Integer> items = new HashMap<String, Integer>();
    items.put("コーラ", 100);
    items.put("オレンジジュース", 120);
    items.put("水", 80);

    return items;
  }

  // ②入金
  private static int deposit(Scanner scanner, int deposit) {
    System.out.println("お金を入れて下さい。");
    deposit = deposit + scanner.nextInt();

    return deposit;
  }

  // ③金額チェック（最低購入金額）
  private static boolean isMinSaleAmount(Map<String, Integer> items, int deposit) {
    int minSaleAmount = -1;
    int loopCount = 0;
    for (String itemKey : items.keySet()) {
      if (loopCount == 0 || minSaleAmount > items.get(itemKey)) {
        minSaleAmount = items.get(itemKey);
      }
      loopCount++;
    }

    if (deposit < minSaleAmount) {
      return false;
    }
    return true;
  }

  // ④商品選択
  private static Map<String, Integer> selectItem(Map<String, Integer> items, int deposit) {
    System.out.println("商品を選択してください。");
    Map<String, Integer> availablePurchases = new HashMap<String, Integer>();
    for (String itemKey : items.keySet()) {
      if (deposit >= items.get(itemKey)) {
        System.out.println(itemKey + ":" + items.get(itemKey) + "円");
        availablePurchases.put(itemKey, items.get(itemKey));
      }
    }
    return availablePurchases;
  }

  // ⑤販売
  private static String saleItem(Scanner scanner, Map<String, Integer> availablePurchases) {
    String itemName = "";
    while (true) {
      itemName = scanner.next();
      if (availablePurchases.containsKey(itemName)) {
        break;
      }
      System.out.println("商品名の指定が誤っています。商品名を指定し直してください。");
    }

    System.out.println(itemName + "です！");
    return itemName;
  }

  // ⑥課金
  private static void charge(int deposit, Map<String, Integer> availablePurchases, String itemName) {
    int charge = deposit - availablePurchases.get(itemName).intValue();
    System.out.println("おつりは、" + charge + "円です。");
  }

}
