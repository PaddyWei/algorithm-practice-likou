package demo;

/**
 * @ClassName : Demo
 * @Description : TODO
 * @Author : DukeWei
 * @Date : 2020/10/21 11:34
 * @Version : 1.0
 **/
public class Demo {

    private String startTime;
    private String endTime;

    public Demo() {
    }

    public Demo(String string1, String string2) {
        this.startTime = string1;
        this.endTime = string2;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
