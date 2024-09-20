package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemCompanyListBinding
import com.example.myapplication.model.CompanyResponseItem

class PostAdapter(
    private val context: Context,
    private var postList: ArrayList<CompanyResponseItem>
) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    lateinit var itemCompanyListBinding: ItemCompanyListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        itemCompanyListBinding =
            ItemCompanyListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PostViewHolder(itemCompanyListBinding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        itemCompanyListBinding.txtCompanyId.text = post.id.toString()
        itemCompanyListBinding.txtCompanyLocation.text =
            "Latitude:" + post.address?.geo?.lat + "Langitude:" + post.address?.geo?.lng
        itemCompanyListBinding.txtCompanyName.text = post.company?.name
    }

    override fun getItemCount(): Int = postList.size

    class PostViewHolder(var binding: ItemCompanyListBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}