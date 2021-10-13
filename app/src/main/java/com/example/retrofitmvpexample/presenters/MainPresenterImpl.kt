package com.example.retrofitmvpexample.presenters

import android.util.Log
import com.example.retrofitmvpexample.model.GithubUserResponse
import com.example.retrofitmvpexample.model.Item
import com.example.retrofitmvpexample.model.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenterImpl(val viewImpl: MainViewPresenterContract.MainView)
    : MainViewPresenterContract.MainPresenter {
    private lateinit var repository: Repository

    override fun initialize() {
        //let's initialize our repository instance here
        repository = Repository()
    }

    //this method retrieves our userList
    override fun getUsersList(queryParameter: String, sortParameter: String) {

        repository.getGithubResponse(queryParameter, sortParameter)
            ?.enqueue(object : Callback<GithubUserResponse?> {
                override fun onResponse(
                    call: Call<GithubUserResponse?>,
                    response: Response<GithubUserResponse?>
                ) {
                    if (response.isSuccessful) {
                        //as soon as we retrieve our list, we'll display it in the
                        //view
                        viewImpl.displayGithubUserList(response.body()!!.items)
                    }
                }

                override fun onFailure(call: Call<GithubUserResponse?>, t: Throwable) {
                    Log.d("retrofit_error", t.message.toString())
                }

            })
    }
}