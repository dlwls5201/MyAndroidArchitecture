package com.tistory.black_jin0427.myandroidarchitecture.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.view.View
import com.tistory.black_jin0427.myandroidarchitecture.adapter.MainAdapter
import com.tistory.black_jin0427.myandroidarchitecture.api.GithubApi
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User
import com.tistory.black_jin0427.myandroidarchitecture.constant.RANDOM_USER_URL
import com.tistory.black_jin0427.myandroidarchitecture.rxEventBus.RxEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserListViewModel(
        private val mainAdapter: MainAdapter,
        private val api: GithubApi)
    : DisposableViewModel() {

    private val _progressView   = MutableLiveData<Int>()
    private val _items          = MutableLiveData<List<User>>()

    private val _adapter        = MutableLiveData<MainAdapter>().apply { value =  mainAdapter }

    val progressView: LiveData<Int> get()    = _progressView
    val items: LiveData<List<User>> get()    = _items
    val adapter: LiveData<MainAdapter> get() = _adapter

    init {

        Log.d("blackJin", "init")
        //_adapter.value = mainAdapter

        registerEvent()
        loadData()

    }

    private fun registerEvent() {

        addDisposable(
                RxEvent.getInstance()
                        .observable
                        .subscribe { user ->
                            if (user is User) {
                                _adapter.value?.updateView(user)
                            }
                        }
        )
    }

    private fun loadData() {

        addDisposable(
                api.getUserList(RANDOM_USER_URL)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe {
                            showProgress()
                        }
                        .doOnTerminate {
                            hideProgress()
                        }
                        .subscribe({ userResponse ->
                            _items.value = userResponse.userList
                        }, {
                            error -> Log.e("blackJin", error.message)
                        })
        )

    }

    private fun showProgress() {
        _progressView.value = View.VISIBLE
    }

    private fun hideProgress() {
        _progressView.value = View.INVISIBLE
    }

}