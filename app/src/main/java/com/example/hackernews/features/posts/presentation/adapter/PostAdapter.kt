package com.example.hackernews.features.posts.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackernews.R
import com.example.hackernews.features.posts.presentation.model.PostModel
import kotlinx.android.synthetic.main.item_news.view.*

class PostAdapter(
    private val onDelete: (id: Long)-> Unit,
    private val onClick: (url: String?) -> Unit): RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private val list = mutableListOf<PostModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    fun setItems(items: List<PostModel>){
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun removeItem(id: Long){
        val pos = list.indexOfFirst { it.id == id }
        if (pos>-1){
            list.removeAt(pos)
            notifyItemRemoved(pos)
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        init {
            itemView.setOnClickListener {
                onClick(list[adapterPosition].url)
            }

            itemView.tvDelete.setOnClickListener {
                onDelete(list[adapterPosition].id)
            }
        }


        fun bindView(post: PostModel){
            itemView.swipeLayout.apply(false)
            itemView.tvTitle.text = post.title
            itemView.tvSub.text = "${post.author} - ${post.createdAt}"
        }
    }
}