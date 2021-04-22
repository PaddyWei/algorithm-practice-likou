package demo;

/**
 * @ClassName : Car
 * @Description : Car
 * @Author : DukeWei
 * @Date : 2020/12/22 15:56
 * @Version : 1.0
 **/
public class Car {

    // 车牌号
    private String code;
    // 颜色
    private String color;
    // 生产商
    private String factory;
    // 价格
    private double price;

    public Car(String code, String color, String factory, double price) {
        this.code = code;
        this.color = color;
        this.factory = factory;
        this.price = price;
    }

    public Car(String code, Double price) {
        this.code = code;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "code='" + code + '\'' +
                ", color='" + color + '\'' +
                ", factory='" + factory + '\'' +
                ", price=" + price +
                '}';
    }
}
