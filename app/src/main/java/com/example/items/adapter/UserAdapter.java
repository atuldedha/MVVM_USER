package com.example.items.adapter;

import android.content.Context;
import android.content.Intent;
import android.drm.DrmStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.items.R;
import com.example.items.ShowUsersActivity;
import com.example.items.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<UserModel> userModel = new ArrayList<>();
    Context mContext;

    public UserAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public UserAdapter(List<UserModel> userModel, Context mContext) {
        this.userModel = userModel;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.single_user_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {

        String name = userModel.get(position).getName();
        String city = userModel.get(position).getCity();

        holder.nameTextView.setText(name);
        holder.cityTextView.setText(city);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent showIntent = new Intent(mContext, ShowUsersActivity.class);
                showIntent.putExtra("name", userModel.get(position).getName());
                showIntent.putExtra("city", userModel.get(position).getCity());
                showIntent.putExtra("age", userModel.get(position).getAge());
                showIntent.putExtra("gender", userModel.get(position).getGender());

                mContext.startActivity(showIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return userModel.size();
    }

    public void setData(List<UserModel> userModel){
        this.userModel = userModel;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView, cityTextView;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            cityTextView = itemView.findViewById(R.id.cityTextView);

        }
    }
}
