package com.niuyitong;

import java.util.ArrayList;
import java.util.List;

public class User {
    String username;
    String password;
    String gender;
    int age;
    String address;
    String title;

    public User(String username, String password, String gender, int age, String address, String title) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.title = title;
    }

    private static List<User> userList = new ArrayList<>();
    static {
        userList.add(new User("a1", "a", "男", 18, "西安大雁塔", "法师"));
        userList.add(new User("a2", "bb", "女", 19, "五行山", "行者"));
        userList.add(new User("c3", "ccc", "女", 17, "高老庄", "守门人"));
    }

    public static User login(String username, String password) {
        for (User user : userList) {
            if (user.username.equals(username)
                    && user.password.equals(password)) {
                return user;
            }
        }

        return null;
    }
}
