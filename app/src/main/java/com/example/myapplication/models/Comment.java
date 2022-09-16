package com.example.myapplication.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

import org.parceler.Parcel;

@ParseClassName("Comment")
@Parcel(analyze = Comment.class)
public class Comment extends ParseObject {
    public static final String KEY_COMMENT = "UserComment";
    public static final String KEY_USER = "ListComment";

    public Comment(){}

    public String getComment(){
        return getString(KEY_COMMENT);
    }
    public void setComment(String Comment){
        put(KEY_COMMENT,Comment);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }
    public void setUser(ParseUser user){
        put(KEY_USER,user);
    }
}
