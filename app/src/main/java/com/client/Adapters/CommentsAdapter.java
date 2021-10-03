package com.client.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.client.DTOs.CommentForRecieveDTO;
import com.client.R;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {

    private List<CommentForRecieveDTO> comment;

    public CommentsAdapter(List<CommentForRecieveDTO> comments) {
        this.comment = comments;
    }

    public void updateData(List<CommentForRecieveDTO> comments){
        comment.clear();
        this.comment = comments;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comment, parent, false);

        return new CommentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.CommentViewHolder holder, int position) {
        CommentForRecieveDTO cnt = comment.get(position);

        holder.userNameTV.setText(cnt.getUserName());
        holder.dateTV.setText(cnt.getDate());
        holder.commentTV.setText(cnt.getText());
    }

    @Override
    public int getItemCount() {
        return comment.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder{

        public TextView userNameTV, dateTV, commentTV;

        public CommentViewHolder(View itemView) {
            super(itemView);
            userNameTV = itemView.findViewById(R.id.userName);
            dateTV = itemView.findViewById(R.id.date);
            commentTV = itemView.findViewById(R.id.commentText);
        }
    }
}
