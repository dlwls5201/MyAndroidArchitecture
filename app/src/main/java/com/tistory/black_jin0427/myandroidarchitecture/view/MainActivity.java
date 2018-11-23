package com.tistory.black_jin0427.myandroidarchitecture.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.tistory.black_jin0427.myandroidarchitecture.BaseActivity;
import com.tistory.black_jin0427.myandroidarchitecture.R;
import com.tistory.black_jin0427.myandroidarchitecture.adapter.MainAdapter;
import com.tistory.black_jin0427.myandroidarchitecture.api.GithubApi;
import com.tistory.black_jin0427.myandroidarchitecture.api.GithubApiProvider;
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.api.model.UserResponse;
import com.tistory.black_jin0427.myandroidarchitecture.constant.Constant;
import com.tistory.black_jin0427.myandroidarchitecture.rxEventBus.RxEvent;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements MainAdapter.OnItemClickListener {

    private CompositeDisposable disposable = new CompositeDisposable();

    private GithubApi api = GithubApiProvider.provideGithubApi();

    private MainAdapter adapter = new MainAdapter();

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

        disposable.add(api.getUserList(Constant.RANDOM_USER_URL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> {
                    progressBar.setVisibility(View.VISIBLE);
                })
                .doOnTerminate(() -> {
                    progressBar.setVisibility(View.GONE);
                })
                .subscribe(userResponse -> {
                    //아이템 로드
                    adapter.setItems((ArrayList<User>)userResponse.userList);
                }, error -> {
                    showToast(error.getMessage());
                })
        );

        disposable.add(
                RxEvent.getInstance()
                        .getObservable()
                        .subscribe(
                                object -> {
                                    if(object instanceof User) {
                                        adapter.updateView((User) object);
                                    }
                                },
                                error -> {
                                    Log.d("MyTag","onError");
                                },
                                () -> {
                                    Log.d("MyTag","onCompleted");
                                }
                        )
        );

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }

    @Override
    public void onClick(User user) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.KEY_USER, user);
        startActivity(intent);
    }
}
