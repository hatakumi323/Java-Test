class Main {
  public static void main(String[] args){

    double triangleAre = calcTriangleArea(10.5, 5.0);
    System.out.println("三角形の面積：" + triangleAre + "平方㎝");

    double circleArea = calcCircleArea(5.0);
    System.out.println("円の面積：" + circleArea + "平方㎝目");
  }

  public static double calcTriangleArea(double bottom, double height){
    double area = (bottom * height) / 2;
    return area;
  }

  public static double calcCircleArea(double radius){
    double area =  radius * radius * 3.14;
    return area;
  }

}
