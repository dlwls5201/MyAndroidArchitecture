package com.tistory.black_jin0427.myandroidarchitecture.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import com.tistory.black_jin0427.myandroidarchitecture.BaseActivity
import com.tistory.black_jin0427.myandroidarchitecture.R
import com.tistory.black_jin0427.myandroidarchitecture.adapter.MainAdapter
import com.tistory.black_jin0427.myandroidarchitecture.api.GithubApi
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User
import com.tistory.black_jin0427.myandroidarchitecture.databinding.ActivityMainBinding
import com.tistory.black_jin0427.myandroidarchitecture.viewModel.UserListViewModel
import com.tistory.black_jin0427.myandroidarchitecture.viewModel.UserListViewModelFactory
import org.koin.android.ext.android.inject

//https://kaidroid.me/post/android-mvvm-viewmodel-livedata-databinding/
class MainActivity : BaseActivity<ActivityMainBinding>(), MainAdapter.OnItemClickListener {

    override val layoutResourceId = R.layout.activity_main

    private val adapter = MainAdapter().apply { setClickListener(this@MainActivity) }

    private val api: GithubApi by inject()


    private lateinit var userListViewModel: UserListViewModel

    private lateinit var userListViewModelFactory: UserListViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "RANDOM USER"

        // 뷰 모델 팩토리 선언
        userListViewModelFactory = UserListViewModelFactory(adapter, api)

        // 뷰 모델 초기화 및 관찰자 연결
        userListViewModel = ViewModelProviders.of(this, userListViewModelFactory).get(UserListViewModel::class.java)

        // 데이터 바인딩에 뷰 모델 연결
        viewDataBinding.model = userListViewModel

        // 데이터 바인딩에 LifecycleOwner 연결하여 liveData 를 DataBinding 과 사용 할 수 있게 함
        viewDataBinding.setLifecycleOwner(this)

    }

    // MainAdapter 의 ClickListener
    override fun onClick(user: User) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.KEY_USER, user)
        startActivity(intent)
    }
}
