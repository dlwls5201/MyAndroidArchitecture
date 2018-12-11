package com.tistory.black_jin0427.myandroidarchitecture.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.tistory.black_jin0427.myandroidarchitecture.BaseActivity
import com.tistory.black_jin0427.myandroidarchitecture.R
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User
import com.tistory.black_jin0427.myandroidarchitecture.databinding.ActivityDetailBinding
import com.tistory.black_jin0427.myandroidarchitecture.viewModel.UserViewModel

class DetailActivity: BaseActivity<ActivityDetailBinding>() {

    companion object {

        val KEY_USER = "key_user"
    }

    override val layoutResourceId = R.layout.activity_detail

    private lateinit var userViewModel: UserViewModel

    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 모델 초기화 및 관찰자 연결
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        // 데이터 바인딩에 뷰 모델 연결
        viewDataBinding.user = userViewModel

        // 데이터 바인딩에 LifecycleOwner 연결하여 liveData 를 DataBinding 과 사용 할 수 있게 함
        viewDataBinding.setLifecycleOwner(this)

        // 데이터 초기화
        getUserFromIntent()
    }

    private fun getUserFromIntent() {
        user    = intent.getSerializableExtra(KEY_USER) as User
        title   = user.fullName

        setData()
    }

    private fun setData() {

        userViewModel.setUser(user)

    }
}
