package comment;

import java.lang.annotation.*;

/**
 * 打印出入参数日志
 */
@Target(ElementType.METHOD)      //定义该注解的作用范围
@Retention(RetentionPolicy.RUNTIME)//定义该注解的生命周期
@Documented                        //注解将生成到javadoc中
public @interface OuterService {
    /**
     * 默认打印输入参数
     * @return
     */
    boolean isInLog() default true;

    /**
     * 默认打印输出参数
     * @return
     */
    boolean isOutLog() default true;

}
