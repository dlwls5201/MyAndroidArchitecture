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

//https://kaidroid.me/post/android-mvvm-viewmodel-livedata-databinding/
class UserViewModel: DisposableViewModel() {

   /* val username    = "username"
    val profileUrl  = "https://t1.daumcdn.net/cfile/tistory/2511E03B577BB58733"
    val likeCnt     = "likeCnt"*/

    /*val username    = ObservableField<String>()
    val profileUrl  = ObservableField<String>()
    val likeCnt     = ObservableField<Int>()*/

    private val _username   = MutableLiveData<String>()
    private val _profileUrl = MutableLiveData<String>()
    private val _likeCnt    = MutableLiveData<Int>()

    //mutableLiveData 를 immutable 하게 노출
    //ViewModel 내부에서는 Mutable 한 데이터를 외부에서는 Immutable 하게 사용하도록 제약을 주기 위함
    val username: LiveData<String> get()    = _username
    val profileUrl: LiveData<String> get()  = _profileUrl
    val likeCnt: LiveData<Int> get()        = _likeCnt

    private var user: User? = null

    fun setUser(user: User) {
        this.user = user

        // setValue, postValue 둘 다 가능
        _username.value = user.fullName
        _profileUrl.value = user.picture?.large
        _likeCnt.value = user.likeCnt

       /* _username.postValue(user.fullName)
        _profileUrl.postValue(user.picture.large)
        _likeCnt.postValue(user.likeCnt)*/
    }

    fun addLikeCnt() {

        _likeCnt.value = _likeCnt.value?.plus(1)

        this.user?.likeCnt = _likeCnt.value ?: 0

        RxEvent.getInstance().sendEvent(user)
    }

    /*fun setUser(user: User) {
        Log.d("MyTag", "user : ${user.fullName}")
        Log.d("MyTag", "picture : ${user.picture.large}")
        Log.d("MyTag", "likeCnt : ${user.likeCnt}")

        username.set(user.fullName)
        profileUrl.set(user.picture.large)
        likeCnt.set(user.likeCnt)
    }

    fun addLikeCnt() {
        var temp = likeCnt.get()

        temp?.let {
            temp++
            Log.d("MyTag","temp : $temp")

            likeCnt.set(temp)
        }

    }*/

}