package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.myapplication.Constant.DonnerConstant;
import com.example.myapplication.Constant.TimeFormatter;
import com.example.myapplication.R;
import com.example.myapplication.adapter.CommentAdapter;
import com.example.myapplication.models.Comment;
import com.example.myapplication.models.Post;
import com.example.myapplication.models.User;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private TextView tvUsername;
    private ImageView ivPhoto, profile;
    private TextView tvDescription;
    private TextView coeur,coeur1,send,bookmark,comment,heure;
    RecyclerView rvComment;
    Context context;
    protected List<Comment> comments;
    protected CommentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Post post = Parcels.unwrap(getIntent().getParcelableExtra(DonnerConstant.DATA));
        coeur = findViewById(R.id.coeur);
        heure = findViewById(R.id.heure);
        coeur1 = findViewById(R.id.coeur1);
        send = findViewById(R.id.share);
        bookmark = findViewById(R.id.bookmark);
        comment = findViewById(R.id.comment);
        rvComment = findViewById(R.id.Comment);
        tvUsername = findViewById(R.id.username);
        tvDescription = findViewById(R.id.description);
        ivPhoto = findViewById(R.id.photo);
        profile = findViewById(R.id.profile);

        comments = new ArrayList<>();
        adapter = new CommentAdapter(context,comments);
        rvComment.setLayoutManager(new LinearLayoutManager(context));



        String username = post.getUser().getUsername();
        String description = post.getDescription();
        String picture = post.getImage().getUrl();
        String profile_url = post.getUser().getParseFile(User.KEY_PROFILE).getUrl();
        String timestamp = TimeFormatter.getTimeStamp(post.getCreatedAt().toString());

        tvDescription.setText(description);
        tvUsername.setText(username);
        heure.setText(timestamp);

        Glide.with(DetailActivity.this).load(profile_url)
                .transform(new RoundedCorners(DonnerConstant.ROUNDED_PROFILE)).into(profile);
        Glide.with(DetailActivity.this).load(picture)
                .transform(new RoundedCorners(DonnerConstant.ROUNDED_PICTURE)).into(ivPhoto);




    }
}