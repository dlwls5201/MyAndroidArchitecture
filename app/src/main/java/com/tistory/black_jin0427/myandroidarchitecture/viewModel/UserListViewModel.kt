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

class UserListViewModel: DisposableViewModel() {

    /*private val _progressView   = ObservableField<Int>()
    private val _items          = ObservableField<List<User>>()
    private val _adapter        = ObservableField<MainAdapter>()

    val progressView: ObservableField<Int> get()    = _progressView
    val items: ObservableField<List<User>> get()    = _items
    val adapter: ObservableField<MainAdapter> get() = _adapter*/

    private val _progressView   = MutableLiveData<Int>()

    private val _items          = MutableLiveData<List<User>>()

    private val _adapter        = MutableLiveData<MainAdapter>()


    val progressView: LiveData<Int> get()    = _progressView

    val items: LiveData<List<User>> get()    = _items

    val adapter: LiveData<MainAdapter> get() = _adapter


    init {

        Log.d("blackJin", "init")
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

    fun setAdapter(adapter: MainAdapter) {
        _adapter.value = adapter
    }

    fun loadData(api: GithubApi) {

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