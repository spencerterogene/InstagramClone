package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.myapplication.R;
import com.example.myapplication.models.Post;
import com.parse.ParseFile;


public class PostAdapter extends  RecyclerView.Adapter<PostAdapter.ViewHolder>{
    private final Context context;
    private final List<Post> posts;

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {

        return posts.size();
    }

    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUsername;
        private ImageView ivPhoto;
        private TextView tvDescription;
        private TextView coeur,coeur1,send,bookmark,comment,heure;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coeur = itemView.findViewById(R.id.coeur);
            heure = itemView.findViewById(R.id.heure);
            coeur1 = itemView.findViewById(R.id.coeur1);
            send = itemView.findViewById(R.id.share);
            bookmark = itemView.findViewById(R.id.bookmark);
            comment = itemView.findViewById(R.id.comment);

            tvUsername = itemView.findViewById(R.id.username);
            tvDescription = itemView.findViewById(R.id.description);
            ivPhoto = itemView.findViewById(R.id.photo);

        }


        public void bind(Post post) {
            tvDescription.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername());
            heure.setText(post.getCreatedAt().toString());
            coeur = itemView.findViewById(R.id.coeur);
            coeur1 = itemView.findViewById(R.id.coeur1);
            send = itemView.findViewById(R.id.share);
            bookmark = itemView.findViewById(R.id.bookmark);
            comment = itemView.findViewById(R.id.comment);
            ParseFile image = post.getImage();
            if(image != null){
                Glide.with(context).load(post.getImage().getUrl()) .centerCrop() // scale image to fill the entire ImageView
                        .transform(new RoundedCorners(30)).into(ivPhoto);

            }
        }
    }
}
