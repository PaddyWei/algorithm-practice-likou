package demo;

import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * 合并时间段 -- 针对一天二十四小时的时间
     * @param collect ["11:30:00-12:30:00","13:30:00-14:30:00","15:30:00-16:30:00"]
     * @return
     */
    public static List<String> mergeTimeByDay(List<String> collect){
        if (collect == null || collect.size() == 0) {
            return null;
        }
        //对时间进行先后排序
        collect = collect.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < collect.size() - 1; ) {
            String[] split = collect.get(i).split("-");
            String beforeStartTime = split[0];
            String beforeEndTime = split[1];
            String[] oldSplit = collect.get(i + 1).split("-");
            String afterStartTime = oldSplit[0];
            String afterEndTime = oldSplit[1];
            if (beforeStartTime.compareTo(afterEndTime) > 0 || beforeEndTime.compareTo(afterStartTime) < 0) {
                i++;
                continue;
            }
            int i1 = beforeStartTime.compareTo(afterStartTime);
            int i2 = beforeStartTime.compareTo(afterEndTime);
            if (afterStartTime.compareTo(beforeStartTime) >= 0 && afterStartTime.compareTo(beforeEndTime) <= 0) {
                afterStartTime = beforeStartTime.compareTo(afterStartTime) < 0 ? beforeStartTime : afterStartTime;
                afterEndTime = beforeEndTime.compareTo(afterEndTime) > 0 ? beforeEndTime : afterEndTime;
            }
            int i3 = beforeEndTime.compareTo(afterStartTime);
            int i4 = beforeEndTime.compareTo(afterEndTime);
            if (afterEndTime.compareTo(beforeStartTime) <= 0 && afterEndTime.compareTo(beforeEndTime) >= 0) {
                afterStartTime = beforeStartTime.compareTo(afterStartTime) < 0 ? beforeStartTime : afterStartTime;
                afterEndTime = beforeEndTime.compareTo(afterEndTime) > 0 ? beforeEndTime : afterEndTime;
            }
            String newTime = afterStartTime + "-" + afterEndTime;
            collect.remove(i);
            collect.set(i, newTime);
        }

        return collect;
    }

}
