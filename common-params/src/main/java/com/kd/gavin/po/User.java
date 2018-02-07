package com.kd.gavin.po;

/**
 * @author kd_gavin
 * @time 2018/2/7,10:48
 * @dicription 注意当API之间传递对象的时候，必须是要一种对象类型
 */
public class User {

    private Long id;
    private String name;
    private int age;
    private int sex;

    public User() {
    }

    public User(Long id, String name, int age, int sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
