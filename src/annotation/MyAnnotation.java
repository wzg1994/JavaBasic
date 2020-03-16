package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//表示注解可以使用的范围
@Target({ElementType.TYPE,ElementType.METHOD})
//表示注解在什么时候有效（runtime > class > source）
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    //此为注解的参数，并不是方法
    //参数类型 + 参数名 + （）
    //这里可以给注解赋一个默认值，如果没有默认值则会报错
    String name() default "";

    //如果默认值为-1则表示不存在
    int age() default -1;

    String[] school() default {"清华大学", "北京大学"};

}
