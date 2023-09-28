package com.example.vplectures.activities.api;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vplectures.databinding.RvPostsItemBinding;

public class PostsViewHolder extends RecyclerView.ViewHolder {
    RvPostsItemBinding binding;

    public PostsViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = RvPostsItemBinding.bind(itemView);
    }
}
