package demo;

/**
 * @ClassName : Utils
 * @Description : Utils
 * @Author : DukeWei
 * @Date : 2020/9/28 10:41
 * @Version : 1.0
 **/
public class Utils {

    /**
     * 根据string转换int数组
     *
     * @param input
     * @return
     */
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

}
