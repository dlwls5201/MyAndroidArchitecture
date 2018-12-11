package com.tistory.black_jin0427.myandroidarchitecture.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User
import com.tistory.black_jin0427.myandroidarchitecture.rxEventBus.RxEvent

class UserViewModel: DisposableViewModel() {

    private val _username   = MutableLiveData<String>()
    private val _profileUrl = MutableLiveData<String>()
    private val _likeCnt    = MutableLiveData<Int>()

    //mutableLiveData 를 immutable 하게 노출
    //ViewModel 내부에서는 Mutable 한 데이터를 외부에서는 Immutable 하게 사용하도록 제약을 주기 위함
    val username: LiveData<String> get()    = _username
    val profileUrl: LiveData<String> get()  = _profileUrl
    val likeCnt: LiveData<Int> get()        = _likeCnt

    private var user: User? = null

    // data setting
    fun setUser(user: User) {
        this.user = user

        _username.value = user.fullName
        _profileUrl.value = user.picture?.large
        _likeCnt.value = user.likeCnt

    }

    // plus like count and event to rxBus when click like button
    fun addLikeCnt() {

        _likeCnt.value = _likeCnt.value?.plus(1)

        this.user?.likeCnt = _likeCnt.value ?: 0

        RxEvent.getInstance().sendEvent(user)
    }
}