package com.example.retrofitmvpexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmvpexample.R
import com.example.retrofitmvpexample.model.Item
import com.example.retrofitmvpexample.presenters.BasePresenter
import com.example.retrofitmvpexample.presenters.MainPresenterImpl
import com.example.retrofitmvpexample.presenters.MainViewPresenterContract
import com.example.retrofitmvpexample.view.adapters.GithubUserAdapter

class MainActivity : AppCompatActivity(), MainViewPresenterContract.MainView {
    private lateinit var mainPresenter: MainViewPresenterContract.MainPresenter
    private lateinit var mGithubRv: RecyclerView
    private lateinit var mAdapter: GithubUserAdapter
    private lateinit var mUserList: List<Item>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize your main presenter implementation
        mainPresenter = MainPresenterImpl(this as MainViewPresenterContract.MainView)
        mainPresenter.initialize()

        initializeViews()

        //let's start the process of getting data from our main presenter
        mainPresenter.getUsersList("tetchi", "repositories")
    }

    override fun onStop() {
        super.onStop()
        //you should have a method from presenter to save the data
        //mainpresenter.saveData()
    }

    override fun onSaveInstanceState(outState: Bundle) {
//        outState.putBundle()
        super.onSaveInstanceState(outState)
    }

    fun initializeViews() {
        mGithubRv = findViewById(R.id.github_rv)
        mGithubRv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
//        mGithubRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    override fun displayGithubUserList(users: List<Item>) {
        //have logic to display the recyclerview
        mAdapter = GithubUserAdapter(users)
        mGithubRv.adapter = mAdapter
        mUserList = users
    }

    override fun setPresenter(presenter: BasePresenter) {
        mainPresenter = presenter as MainViewPresenterContract.MainPresenter
    }
}