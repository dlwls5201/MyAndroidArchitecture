package com.tistory.black_jin0427.myandroidarchitecture

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import butterknife.ButterKnife

abstract class BaseActivity<T: ViewDataBinding>:  AppCompatActivity(){

    lateinit var viewDataBinding: T

    abstract val layoutResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)
    }
}