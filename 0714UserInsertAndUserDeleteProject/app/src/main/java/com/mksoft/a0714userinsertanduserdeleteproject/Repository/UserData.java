package com.mksoft.a0714userinsertanduserdeleteproject.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {
    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("age")
    @Expose
    Integer age;

    public UserData(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public UserData() {
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
