package com.example.vplectures.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vplectures.R;
import com.example.vplectures.databinding.RvWithVbItemBinding;
import com.example.vplectures.models.RvVbModel;

import java.util.ArrayList;

public class RvWithVbAdapter extends RecyclerView.Adapter<RvWithVbAdapter.RvWithVbViewHolder> {
    ArrayList<RvVbModel> list;
    Context c;

    public RvWithVbAdapter(ArrayList<RvVbModel> l, Context ctx) {
        list = l;
        c = ctx;
    }

    @NonNull
    @Override
    public RvWithVbViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RvWithVbItemBinding inflate = RvWithVbItemBinding.inflate(LayoutInflater.from(c), parent, false);
        return new RvWithVbAdapter.RvWithVbViewHolder(inflate.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RvWithVbAdapter.RvWithVbViewHolder holder, int position) {
        RvVbModel m = list.get(position);

        holder.binding.tvTitle.setText(m.getTitle());
        holder.binding.tvSubtitle.setText(m.getSubtitle());
        holder.binding.tvPrice.setText(m.getPrice());

        holder.binding.getRoot().setOnClickListener(view -> {
            String msg = "Title: " + m.getTitle() + " Subtitle: " + m.getSubtitle();
            Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
        });

//        Drawable d = AppCompatResources.getDrawable(c, R.drawable.baseline_chevron_left_24);
//        holder.binding.image.setImageDrawable(d);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RvWithVbViewHolder extends RecyclerView.ViewHolder {
        RvWithVbItemBinding binding;

        public RvWithVbViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RvWithVbItemBinding.bind(itemView);
        }
    }
}
