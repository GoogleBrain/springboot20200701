package cn.k.springboot01.domain;

public class User {

    private String name;
    private Integer age;
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pass='" + pass + '\'' +
                '}';
    }

    public User(String name, Integer age, String pass) {
        this.name = name;
        this.age = age;
        this.pass = pass;
    }

    public User() {
    }
}
