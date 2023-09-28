package com.example.vplectures.activities.api;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vplectures.activities.api.models.PostsModel;
import com.example.vplectures.databinding.RvPostsItemBinding;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsViewHolder> {
    List<PostsModel> list;

    public PostsAdapter(List<PostsModel> l) {
        list = l;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RvPostsItemBinding inflate = RvPostsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostsViewHolder(inflate.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        PostsModel pm = list.get(position);
        String id = pm.id + "";

        holder.binding.tvId.setText(id);
        holder.binding.tvTitle.setText(pm.title);

        holder.binding.getRoot().setOnClickListener(view -> {
            String msg = "ID: " + pm.id + "\nuserId: " + pm.userId + "\ntitle: " + pm.title + "\nbody:" + pm.body;
            new AlertDialog.Builder(view.getContext()).setTitle("Posts").setMessage(msg)
                    .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss())
                    .create().show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
