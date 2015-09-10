package com.example.owner.todo;


import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by OWNER on 2015/09/09.
 */
@ParseClassName("Task")
public class Task extends ParseObject {
    public String getTitle() {
        return getString("title");
    }
    public boolean isCheck(){
        return getBoolean("check");
    }
    public void setTitle(String title){
        put("title",title);
    }
    public void setCheck(boolean check){
        put("check",check);
    }
}
