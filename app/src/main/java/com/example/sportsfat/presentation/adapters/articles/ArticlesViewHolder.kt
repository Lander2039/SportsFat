package com.example.sportsfat.presentation.adapters.articles

import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListArticlesBinding
import com.example.sportsfat.domain.model.ArticlesModel
import com.example.sportsfat.presentation.adapters.articles.listener.ArticlesListener

class ArticlesViewHolder(
    private val viewBinding: ListArticlesBinding,
    private val articlesListener: ArticlesListener

) : RecyclerView.ViewHolder(viewBinding.root) {


    fun bind(articlesModel: ArticlesModel) {
        viewBinding.tvNameArticles.text = articlesModel.nameArticles
        viewBinding.tvTextArticles.text = articlesModel.textArticles
//        Picasso.get().load(Uri.parse(articlesModel.imageArticles)).into(iv_imageArticles)
    viewBinding.ivImageArticles.setOnClickListener {
        articlesListener.onElementSelected(
            articlesModel.nameArticles,
            articlesModel.imageArticles
        )
    }
    }
}