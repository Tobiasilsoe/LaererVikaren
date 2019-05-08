/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.laerervikaren;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.laerervikaren.database.User;

import java.util.ArrayList;
import java.util.List;

import static com.example.laerervikaren.R.id.description_description;
import static com.example.laerervikaren.R.id.url_url;
import static com.example.laerervikaren.R.id.title_title;
//import static com.example.laerervikaren.R.id.tvAnimalName;

public class MatAdapter extends RecyclerView.Adapter<MatAdapter.ViewHolder> {

    private List<User> users;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MatAdapter(Context context, List<User> data) {
        this.mInflater = LayoutInflater.from(context);
        this.users = data;
    }
    public MatAdapter(List<User> users){
        this.users = users;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerviewmat, parent, false);
        return new ViewHolder(view);
    }




    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(MatAdapter.ViewHolder holder, int position) {
        String title = users.get(position).getTitle();
        holder.myTitle.setText(title);
        String url = users.get(position).getTitle();
        holder.myUrl.setText(url);
        String description = users.get(position).getTitle();
        holder.myDescription.setText(description);
        //Log.d("MYINT", "value: " + users.size());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return users.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTitle;
        TextView myUrl;
        TextView myDescription;

        ViewHolder(View itemView) {
            super(itemView);
            myTitle = itemView.findViewById(title_title);
            itemView.setOnClickListener(this);
            myUrl = itemView.findViewById(url_url);
            itemView.setOnClickListener(this);
            myDescription = itemView.findViewById(description_description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public int getItem() {
        return users.size();
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
