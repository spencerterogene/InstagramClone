package com.example.myapplication.models;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseUser;

import org.parceler.Parcel;

@ParseClassName("User")
@Parcel(analyze = User.class)

public class User  extends ParseUser {
    public User() {
        // Required empty public constructor
    }
    public static final String KEY_PROFILE = "profile";
    public ParseFile getProfile(){
        return getParseFile(KEY_PROFILE);
    }
    public void setProfile(ParseFile parseFile){
        put(KEY_PROFILE,parseFile);
    }
}
