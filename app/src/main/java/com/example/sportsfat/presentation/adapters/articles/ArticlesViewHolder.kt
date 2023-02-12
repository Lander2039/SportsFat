package com.example.sportsfat.presentation.adapters.articles

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListArticlesBinding
import com.example.sportsfat.domain.model.ArticlesModel
import com.example.sportsfat.presentation.adapters.articles.listener.ArticlesListener
import com.squareup.picasso.Picasso

class ArticlesViewHolder(
    private val viewBinding: ListArticlesBinding,
    private val articlesListener: ArticlesListener

) : RecyclerView.ViewHolder(viewBinding.root) {


    fun bind(articlesModel: ArticlesModel) {
        viewBinding.tvNameArticles.text = articlesModel.description
        Picasso.get().load(Uri.parse(articlesModel.image)).into(viewBinding.ivImageArticles)


    viewBinding.ivImageArticles.setOnClickListener {
        articlesListener.onElementSelected(
            articlesModel.description,
            articlesModel.image,
            articlesModel.articlesText
        )
    }
    }
}