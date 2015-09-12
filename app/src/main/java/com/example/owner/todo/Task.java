package com.example.owner.todo;


import android.graphics.Color;
import android.widget.CheckBox;

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
    public boolean isCheck(boolean check,CheckBox checkBox){
        return getBoolean("check");
       /* if(check == true) {
            checkBox.setBackgroundColor(Color.parseColor());
        } */
    }
    public void setTitle(String title){
        put("title",title);
    }
    public void setCheck(boolean check){
        put("check", check);
    }
}
