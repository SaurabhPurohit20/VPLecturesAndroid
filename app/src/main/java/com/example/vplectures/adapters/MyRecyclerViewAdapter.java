package com.example.vplectures.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vplectures.R;
import com.example.vplectures.models.Student;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    ArrayList<Student> list;

    private final LayoutInflater mInflater;

    public MyRecyclerViewAdapter(Context context, ArrayList<Student> l) {
        list = l;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String id = list.get(position).getId(),
                name = list.get(position).getName(),
                date = list.get(position).getDate();

        holder.tvName.setText(name);
        holder.tvId.setText(id);
        holder.tvDate.setText(date);

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Name:" + name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvName, tvDate;

        ViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDate = itemView.findViewById(R.id.tv_date);
        }
    }
}
