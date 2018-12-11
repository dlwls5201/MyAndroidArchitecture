package com.tistory.black_jin0427.myandroidarchitecture.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import butterknife.BindView
import com.tistory.black_jin0427.myandroidarchitecture.BaseActivity
import com.tistory.black_jin0427.myandroidarchitecture.R
import com.tistory.black_jin0427.myandroidarchitecture.adapter.MainAdapter
import com.tistory.black_jin0427.myandroidarchitecture.api.GithubApiProvider
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User
import com.tistory.black_jin0427.myandroidarchitecture.constant.RANDOM_USER_URL
import com.tistory.black_jin0427.myandroidarchitecture.databinding.ActivityMainBinding
import com.tistory.black_jin0427.myandroidarchitecture.lifecycle.AutoClearedDispoasble
import com.tistory.black_jin0427.myandroidarchitecture.rxEventBus.RxEvent
import com.tistory.black_jin0427.myandroidarchitecture.viewModel.UserListViewModel
import com.tistory.black_jin0427.myandroidarchitecture.viewModel.UserViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject
import java.util.*

class MainActivity : BaseActivity<ActivityMainBinding>(), MainAdapter.OnItemClickListener {

    override val layoutResourceId = R.layout.activity_main

    private val adapter = MainAdapter().apply { setClickListener(this@MainActivity) }

    private val api: GithubApiProvider by inject()


    private lateinit var userListViewModel: UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "RANDOM USER"

        // 뷰 모델 초기화 및 관찰자 연결
        userListViewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)

        // 데이터 바인딩에 뷰 모델 연결
        viewDataBinding.model = userListViewModel

        // 데이터 바인딩에 LifecycleOwner 연결하여 liveData 를 DataBinding 과 사용 할 수 있게 함
        viewDataBinding.setLifecycleOwner(this)

        userListViewModel.setAdapter(adapter)
        userListViewModel.loadData(api.getGithubApi())

    }

    override fun onClick(user: User) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.KEY_USER, user)
        startActivity(intent)
    }
}
