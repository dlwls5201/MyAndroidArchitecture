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

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity
        implements MainContract.View, MainAdapter.OnItemClickListener {

    private MainAdapter adapter = new MainAdapter();

    private MainPresenter presenter = new MainPresenter();

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progress_view)
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("RANDOM USER");

        // recycler view 초기화
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        // presenter 와 연결
        presenter.setView(this);

        // 랜덤 유저 데이터를 받아옵니다.
        presenter.loadData();

        // RxEventBus 를 연결합니다.
        presenter.setRxEvent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // presenter 와의 연결을 해제합니다.
        presenter.releaseView();
    }

    @Override
    public void onClick(User user) {
        // 어탭터 리스터로 아이템 클릭 시 상세 유저 화면으로 넘어갑니다.
        // intent 통해 user 데이터를 넘겨줍니다.
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
    // 아이템을 어댑터에 연결해 줍니다.
    public void setItems(ArrayList<User> items) {
        adapter.setItems(items);
    }

    @Override
    // 단일 아이템에 변경되었음을 알려줍니다.
    public void updateView(User user) {
        adapter.updateView(user);
    }

}
