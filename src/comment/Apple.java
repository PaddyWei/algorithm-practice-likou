package comment;

import comment.FruitColor.Color;

/**
 * @ClassName : Apple
 * @Description : 注解使用
 * @Author : DukeWei
 * @Date : 2020/9/28 14:05
 * @Version : 1.0
 **/
public class Apple {
    @FruitName(value = "哈菠萝")
    private String appleName;
    @FruitColor(fruitColor = Color.RED)
    private String appleColor;
    @FruitProvider(id = 598, name = "北集团", address = "北国北省北市北县110号")
    private String appleProvider;

    public Apple() {

    }

    public Apple(String appleName, String appleColor, String appleProvider) {
        this.appleName = appleName;
        this.appleColor = appleColor;
        this.appleProvider = appleProvider;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "appleName='" + appleName + '\'' +
                ", appleColor='" + appleColor + '\'' +
                ", appleProvider='" + appleProvider + '\'' +
                '}';
    }

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
