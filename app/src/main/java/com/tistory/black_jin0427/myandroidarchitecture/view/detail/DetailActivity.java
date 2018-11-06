package com.tistory.black_jin0427.myandroidarchitecture.view.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tistory.black_jin0427.myandroidarchitecture.BaseActivity;
import com.tistory.black_jin0427.myandroidarchitecture.R;
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.rxEventBus.RxEvent;
import com.tistory.black_jin0427.myandroidarchitecture.view.detail.di.DaggerDetailComponent;
import com.tistory.black_jin0427.myandroidarchitecture.view.detail.di.DetailModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends BaseActivity implements DetailContract.View {

    @Inject
    DetailPresenter presenter;

    @BindView(R.id.iv_detail_profile)
    CircleImageView ivDetailProfile;

    @BindView(R.id.tv_detail_like_cnt)
    TextView tvDetailLIkeCnt;

    public final static String KEY_USER = "key_user";

    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getUserFromIntent();

        DaggerDetailComponent.builder()
                .detailModule(new DetailModule(this))
                .build()
                .inject(this);

    }

    private void getUserFromIntent(){
        user = (User) getIntent().getSerializableExtra(KEY_USER);
        setTitle(user.getFullName());
        initData(user);
    }

    private void initData(User user) {

        tvDetailLIkeCnt.setText(user.getLikeCnt());

        Glide.with(this)
                .load(user.picture.large)
                .into(ivDetailProfile);

    }

    @OnClick(R.id.btn_detail_like) void onClick() {
        presenter.clickEvent(user);
    }

    @Override
    public void setText(String text) {
        tvDetailLIkeCnt.setText(text);
    }
}
