package com.amarinag.dadu_fragments.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amarinag.dadu_fragments.R
import com.amarinag.dadu_fragments.network.GithubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserListFragment : Fragment() {
    private val adapter: UserAdapter = UserAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvUsers: RecyclerView = view.findViewById(R.id.rv_users)
        rvUsers.layoutManager = LinearLayoutManager(context)
        rvUsers.adapter = adapter

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val githubService: GithubService = retrofit.create(GithubService::class.java)

        githubService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    adapter.submitList(response.body())
                } else {

                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
            }
        })

    }
}