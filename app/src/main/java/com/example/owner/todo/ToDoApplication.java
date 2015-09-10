package com.example.owner.todo;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by OWNER on 2015/09/09.
 */
public class ToDoApplication extends Application{
    @Override
    public void onCreate(){
        super.onCreate();

        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(Task.class);

        Parse.initialize(this,"XkKh5fskdJzWTiZBse7YXGs60bw2HWZNTRBQubcq","QbuuAiPRaQEhCC46BtFVwJcPtcILr1rxWjvzniRq");
    }
}

