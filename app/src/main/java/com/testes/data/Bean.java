package com.testes.data;

/**
 * Created by Bold on 07/03/2016.
 */
public class Bean {

    public Bean(String name, int age){
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
