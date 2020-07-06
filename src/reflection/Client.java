package reflection;

import fanxing.Student;

public class Client {

    public static void main(String[] args) throws ClassNotFoundException {
        //获取注解有三种方法：
        Class c1 = Class.forName("fanxing.Student");

        Student<String> student = new Student<>();
        Class c2 = student.getClass();

        Class studentClass = Student.class;

        //特殊的内置类型
        Class<Integer> type = Integer.TYPE;
    }
}

class A {
    static {
        m = 0;
    }

    static int m = 1;
}