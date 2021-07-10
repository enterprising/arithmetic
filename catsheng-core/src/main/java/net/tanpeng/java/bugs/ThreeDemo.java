package net.tanpeng.java.bugs;

/**
 * 三元表达式踩坑
 * Created by peng.tan on 2019/6/29.
 */
public class ThreeDemo {
    private Double price;

    public static void main(String[] args) {

        ThreeDemo testDemo = new ThreeDemo();

        Double price = testDemo != null ? testDemo.getPrice() : 0D;

        System.out.println(price);
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}