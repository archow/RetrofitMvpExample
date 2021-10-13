package com.example.retrofitmvpexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitmvpexample.R
import com.example.retrofitmvpexample.model.Item
import com.example.retrofitmvpexample.presenters.BasePresenter
import com.example.retrofitmvpexample.presenters.MainViewPresenterContract

class MainActivity : AppCompatActivity(), MainViewPresenterContract.MainView {
    lateinit var mainPresenter: MainViewPresenterContract.MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun displayGithubUserList(users: List<Item>) {
        //have logic to display the recyclerview
    }

    override fun setPresenter(presenter: BasePresenter) {
        mainPresenter = presenter as MainViewPresenterContract.MainPresenter
    }
}