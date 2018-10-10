package com.tistory.black_jin0427.myandroidarchitecture.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.tistory.black_jin0427.myandroidarchitecture.R;
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.PersonHolder> {

    private ArrayList<User> items = new ArrayList<>();

    private OnItemClickListener listener;

    @NonNull
    @Override
    public MainAdapter.PersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);

        return new PersonHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.PersonHolder personHolder, int position) {

        User user = items.get(personHolder.getAdapterPosition());

        Glide.with(personHolder.itemView.getContext())
                .load(user.picture.large)
                .into(personHolder.ivItemProfile);

        personHolder.tvItemName.setText(user.getFullName());
        personHolder.tvItemPhone.setText(user.phone);
        personHolder.tvItemMail.setText(user.email);
        personHolder.tvItemLikeCnt.setText(user.getLikeCnt());

        personHolder.itemView.setOnClickListener(view
                -> listener.onClick(user));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateView(User user) {

        int pos = getPosition(user);

        if(pos == RecyclerView.NO_POSITION) return;

        items.set(pos, user);
        notifyItemChanged(pos);
    }

    private int getPosition(User user) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getFullName().equals(user.getFullName())) {
                return i;
            }
        }
        return RecyclerView.NO_POSITION;
    }

    public void setItems(ArrayList<User> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void setClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onClick(User user);
    }

    class PersonHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_item_profile)
        CircleImageView ivItemProfile;

        @BindView(R.id.tv_item_name)
        TextView tvItemName;

        @BindView(R.id.tv_item_phone)
        TextView tvItemPhone;

        @BindView(R.id.tv_item_mail)
        TextView tvItemMail;

        @BindView(R.id.tv_item_like_cnt)
        TextView tvItemLikeCnt;

        PersonHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
