package com.tistory.black_jin0427.myandroidarchitecture.view.recently;

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

import butterknife.BindView;

public class RecentActivity extends BaseActivity implements RecentContract.View, MainAdapter.OnItemClickListener  {

    private MainAdapter adapter = new MainAdapter();

    private RecentPresenter presenter = new RecentPresenter();

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progress_view)
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        presenter.setView(this);
    }

    @Override
    public void onClick(User user) {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
