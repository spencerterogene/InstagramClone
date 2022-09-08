package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.PostAdapter;
import com.example.myapplication.models.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class PostFragment extends Fragment {
    public static final String TAG = "PostFragment";
    private RecyclerView Post;
    private PostAdapter adapter;
    private List<Post> allPost;
    public PostFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Post = view.findViewById(R.id.Post);
        allPost = new ArrayList<>();
        adapter = new PostAdapter(getContext(), allPost);
        Post.setAdapter(adapter);
        Post.setLayoutManager(new LinearLayoutManager(getContext()));
        queryPosts();
    }


    private void queryPosts() {
        ParseQuery<com.example.myapplication.models.Post> query = ParseQuery.getQuery(Post.class);
        query.include(com.example.myapplication.models.Post.KEY_USER);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null){
                    Log.i(TAG,"Issue with getting posts",e);
                     return;
                }
                for (Post post:posts){
                    Log.i(TAG,"Post: "+ post.getDescription() + ", username: "+post.getUser().getUsername());
                }
                allPost.addAll(posts);
                adapter.notifyDataSetChanged();
            }
        });
    }
}