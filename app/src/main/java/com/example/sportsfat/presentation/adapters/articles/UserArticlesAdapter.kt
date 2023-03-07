package com.example.sportsfat.presentation.adapters.articles

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListArticlesUserFragmentBinding
import com.example.sportsfat.domain.model.ArticlesModel
import com.example.sportsfat.presentation.adapters.articles.listener.ArticlesListener

class UserArticlesAdapter(
    private val articlesListener: ArticlesListener
) : RecyclerView.Adapter<UserArticlesViewHolder>() {

    private var listArticles = mutableListOf<ArticlesModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<ArticlesModel>) {
        this.listArticles.clear()
        this.listArticles = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserArticlesViewHolder {
        val viewBinding =
            ListArticlesUserFragmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return UserArticlesViewHolder(viewBinding, articlesListener)
    }

    override fun onBindViewHolder(holder: UserArticlesViewHolder, position: Int) {
        holder.bind(listArticles[position])
    }

    override fun getItemCount(): Int {
        return listArticles.size
    }
}