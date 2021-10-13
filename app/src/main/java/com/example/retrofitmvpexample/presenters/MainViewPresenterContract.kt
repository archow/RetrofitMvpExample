package com.example.retrofitmvpexample.presenters

import com.example.retrofitmvpexample.model.Item
import com.example.retrofitmvpexample.view.BaseView

interface MainViewPresenterContract {
    //presenter should have methods defining business/data logic
    //those methods should be available to the view to call
    interface MainPresenter : BasePresenter {
        fun getUsersList(queryParameter: String, sortParameter: String)
    }

    interface MainView : BaseView {
        fun displayGithubUserList(users: List<Item>)
    }
}