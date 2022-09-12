package com.example.myapplication.models;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
@ParseClassName("User")
public class User  extends ParseObject{
    public static final String KEY_PROFILE = "profile";

    public ParseFile getProfile(){
        return getParseFile(KEY_PROFILE);
    }
    public void setProfile(ParseFile parseFile){
        put(KEY_PROFILE,parseFile);
    }
}
