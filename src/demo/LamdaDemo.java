package demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @ClassName : LamdaDemo
 * @Description : Lomda表达式练习
 * @Author : DukeWei
 * @Date : 2020/12/22 15:54
 * @Version : 1.0
 **/
public class LamdaDemo {
    public static List<Car> InitCar(){
        ArrayList<Car> carList = new ArrayList<>();
        Car car1 = new Car("100", "black", "中国", 20);
        Car car2 = new Car("101", "gray", "中国", 30);
        Car car3 = new Car("102", "yello", "中国", 50);
        Car car4 = new Car("103", "silvery", "英国", 20);
        Car car5 = new Car("104", "red", "英国", 30);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        return carList;
    }

    public static void main(String[] args) {
//        List<Car> cars = InitCar();
//        Car car = new Car("100", "black", "中国", 20);
//        cars.add(car);
//        System.out.println(cars);
//        List<Car> carList = new ArrayList<>();
//        System.out.println(cars.stream().sorted(Comparator.comparing(Car::getCode)).collect(Collectors.toList()));
//        System.out.println(carList.stream().sorted(Comparator.comparing(Car::getCode)).collect(Collectors.toList()));
//        List<Car> collect = cars.stream()
//                .filter(car -> car.getPrice() > 10)
//                .filter(car -> !"100".equals(car.getCode()))
//                .filter(car -> "中国".equals(car.getFactory()))
//                .collect(Collectors.toList());
//        List<String> strings = cars.stream().map(Car::getCode).collect(Collectors.toList());
//        System.out.println(cars);
//        System.out.println(collect);

//        Predicate predicate = s -> s.equals("youku1327");
//        boolean youku1327 = predicate.test("youku");
//        System.out.println(youku1327);
//        BiFunction<String, Double, Car> function = Car::new;
//        Car car = function.apply("105", 40d);
//        System.out.println(car);

//        String str1 = "孙子兵法";
//        String str2 = "春秋战国";
//        String str3 = "战国七雄";
//        System.out.println(str1.contains("战国"));
//        System.out.println(str2.contains("战国"));
//        System.out.println(str3.contains("战国"));
//        Map<Long, String> map = new HashMap<>();
//        System.out.println(map.get(0L));
        Integer i = 2;
        System.out.println(aa(i));
        i = aa(i);
        System.out.println(i);
    }

    static Integer aa(Integer i){
        return ++i;
    }
}
