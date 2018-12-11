package com.tistory.black_jin0427.myandroidarchitecture.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.tistory.black_jin0427.myandroidarchitecture.adapter.MainAdapter
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User

@BindingAdapter("url")
fun setImageUrl(view: ImageView, profileUrl: String?) {

    if(!TextUtils.isEmpty(profileUrl)) {
        Glide.with(view.context)
                .load(profileUrl)
                .into(view)
    }
}

@BindingAdapter("bind_adapter")
fun setBindAdapter(view: RecyclerView, adapter: MainAdapter?) {
    adapter?.let {
        view.adapter = it
    }
}

@BindingAdapter("bind_items")
fun setBindItems(view : RecyclerView, items : List<User>?) {
    items?.let {

        val adapter = view.adapter as MainAdapter
        adapter.setItems(items)
        adapter.notifyDataSetChanged()

    }
}
