package com.tistory.black_jin0427.myandroidarchitecture.view.dratil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tistory.black_jin0427.myandroidarchitecture.BaseActivity;
import com.tistory.black_jin0427.myandroidarchitecture.R;
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.rxEventBus.RxEvent;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends BaseActivity {

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
        user.likeCnt++;
        tvDetailLIkeCnt.setText(user.getLikeCnt());

        RxEvent.getInstance().sendEvent(user);
    }
}
