package com.example.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.myapplication.Constant.DonnerConstant;
import com.example.myapplication.R;
import com.example.myapplication.models.Comment;
import com.example.myapplication.models.Comment;
import com.example.myapplication.models.User;
import com.parse.ParseFile;
import com.parse.ParseUser;

import org.parceler.Parcels;

import java.util.List;


public class CommentAdapter extends  RecyclerView.Adapter<CommentAdapter.ViewHolder>{

    private final Context context;
    private final List<Comment> comments;

    public CommentAdapter(Context context, List<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comment, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comment comment = comments.get(position);
        holder.bind(comment);
    }

    @Override
    public int getItemCount() {

        return comments.size();
    }



    public  class ViewHolder extends RecyclerView.ViewHolder{

        private TextView username2;
        private ImageView profile2;
        private TextView commentaire;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username2 = itemView.findViewById(R.id.username2);
            profile2 = itemView.findViewById(R.id.profile2);
            commentaire = itemView.findViewById(R.id.commentaire);

        }


        public void bind(Comment comment) {
            commentaire.setText(comment.getComment());
            username2.setText(comment.getUser().getUsername());

            Glide.with(context).load(comment.getUser().getParseFile(Comment.KEY_COMMENT).getUrl()).centerCrop()
                    .transform(new RoundedCorners(30)).into(profile2);

        }
    }
}
