package com.amarinag.dadu_fragments.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amarinag.dadu_fragments.R

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

        val user = listOf<User>(
            User("1", "Carlos", "imageUrl"),
            User("2", "Marta", "imageUrl"),
            User("3", "Juan", "imageUrl"),
            User("4", "Pedro", "imageUrl"),
        )

        adapter.submitList(user)
    }
}