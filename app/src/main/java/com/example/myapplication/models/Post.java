package com.example.myapplication.models;

import androidx.annotation.Nullable;

import com.parse.Parse;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import org.json.JSONArray;
import org.parceler.Parcel;

@ParseClassName("Post")
@Parcel(analyze = Post.class)
public class Post extends ParseObject {
    public Post() {
        // Required empty public constructor
    }
    public static final String KEY_DESCRIPTION = "Descriptipn";
    public static final String KEY_IMAGE = "Image";
    public static final String KEY_USER = "User";
    public static final String CREATED_AT="createdAt";
    public static final String COMMENT_LIST = "CommentList";


    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }
    public void setDescription(String description){
        put(KEY_DESCRIPTION,description);
    }
    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }
    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE,parseFile);
    }
    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }
    public void setUser(ParseUser user){
        put(KEY_USER,user);
    }

    public JSONArray getCommentList(){
        return getJSONArray(COMMENT_LIST);
    }
    public void setCommentList(ParseObject Comment){
        put(COMMENT_LIST,Comment);
    }
}
