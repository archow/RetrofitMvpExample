package com.example.retrofitmvpexample.model

import com.example.retrofitmvpexample.network.GithubApiService
import com.example.retrofitmvpexample.network.RetrofitClient
import retrofit2.Call

class Repository {
    //here we will have functions (and instances of objects if we need them) to
    //make our network calls and data calls
    //so let's have a function that makes our network call and retrieves a response
    fun getGithubResponse(queryParameter: String, sortParameter: String):
            Call<GithubUserResponse?>? {
        val retrofit = RetrofitClient.getRetrofitClient()
        val apiService = retrofit.create(GithubApiService::class.java)
        return apiService.getGithubResponse(queryParameter, sortParameter)
    }
}