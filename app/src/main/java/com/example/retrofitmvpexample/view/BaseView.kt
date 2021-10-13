package com.example.retrofitmvpexample.view

import com.example.retrofitmvpexample.presenters.BasePresenter

interface BaseView {
    fun setPresenter(presenter: BasePresenter)
}