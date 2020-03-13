package fanxing;

/**
 * @author wangzhiguo
 */
public class Teacher<T, K, U> {

    private T name;

    private K age;

    private U sex;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public K getAge() {
        return age;
    }

    public void setAge(K age) {
        this.age = age;
    }

    public U getSex() {
        return sex;
    }

    public void setSex(U sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name=" + name +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
