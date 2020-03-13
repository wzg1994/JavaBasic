package fanxing;

/**
 * 泛型类
 * @author wangzhiguo
 */
public class Student<T> {

    private T name;

    private T sex;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getSex() {
        return sex;
    }

    public void setSex(T sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", sex=" + sex +
                '}';
    }
}
