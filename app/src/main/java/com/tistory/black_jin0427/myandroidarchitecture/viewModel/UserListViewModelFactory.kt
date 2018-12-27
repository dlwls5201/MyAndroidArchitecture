package com.tistory.black_jin0427.myandroidarchitecture.viewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.tistory.black_jin0427.myandroidarchitecture.adapter.MainAdapter
import com.tistory.black_jin0427.myandroidarchitecture.api.GithubApi

class UserListViewModelFactory(private val mainAdapter: MainAdapter, private val api: GithubApi)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserListViewModel(mainAdapter, api) as T
    }

}