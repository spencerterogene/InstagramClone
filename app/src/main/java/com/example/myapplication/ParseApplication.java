package com.example.myapplication;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);
//        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("sd7HY4YNWZ4bVfnpN8P1EoCnnH1rVh1ocxs4keO1")
                .clientKey("0atO2MGZ3fqRCTSWv8l6VTBrBghbzvjRMCFY9Pwo")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
