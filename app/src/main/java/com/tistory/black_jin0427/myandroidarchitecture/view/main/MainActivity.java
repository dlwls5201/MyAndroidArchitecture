package com.tistory.black_jin0427.myandroidarchitecture.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.tistory.black_jin0427.myandroidarchitecture.BaseActivity;
import com.tistory.black_jin0427.myandroidarchitecture.R;
import com.tistory.black_jin0427.myandroidarchitecture.adapter.MainAdapter;
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.view.detail.DetailActivity;
import com.tistory.black_jin0427.myandroidarchitecture.view.recent.RecentActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity
        implements MainContract.View, MainAdapter.OnItemClickListener {

    @Inject
    MainAdapter adapter;

    @Inject
    MainPresenter presenter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progress_view)
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("RANDOM USER");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        presenter.setView(this);

        presenter.loadData();
        presenter.setRxEvent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.releaseView();
    }

    @Override
    public void onClick(User user) {

        // UserDatabase 에 저장합니다.
        presenter.addUser(user);

        // DetailActivity 로 이동합니다.
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.KEY_USER, user);
        startActivity(intent);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setItems(ArrayList<User> items) {
        adapter.setItems(items);
    }

    @Override
    public void updateView(User user) {
        adapter.updateView(user);
    }

    @OnClick(R.id.btn_recent_user)
    void onClick() {
        Intent intent = new Intent(this, RecentActivity.class);
        startActivity(intent);
    }
}
