package com.example.zoey.example_3.data.helpers;

import com.example.zoey.example_3.data.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class UserHelper {
    public static List<User> getUsersList(int numOfUsers){
        List<User> listOfUsers = new ArrayList<User>();
        for(int i = 0; i < numOfUsers; i++ ){
            User user = new User("zoey" + i,"www.baidu.com/icon" + i, (byte) (i < Byte.MAX_VALUE ? i: new Random().nextInt(Byte.MAX_VALUE)),"zoey"+ i+"@zoey"+i+".com");
            listOfUsers.add(user);
        }
        return listOfUsers;
    }
}
