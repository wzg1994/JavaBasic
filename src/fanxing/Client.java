package fanxing;

/**
 * @author wangzhiguo
 */
public class Client {

    public static void main(String[] args) {
        Student<String> student = new Student<>();
        student.setName("小白");
        System.out.println(student);

        Teacher<String, Integer, String> teacher = new Teacher<>();
        teacher.setName("小黑");
        teacher.setAge(11);
        teacher.setSex("未知");
        System.out.println("teacher类：" + teacher);

    }
}
