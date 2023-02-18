package com.example.sportsfat.presentation.adapters.workouts

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListArticlesBinding
import com.example.sportsfat.databinding.ListWorkoutBinding
import com.example.sportsfat.domain.model.ArticlesModel
import com.example.sportsfat.domain.model.WorkoutModel
import com.example.sportsfat.presentation.adapters.workouts.listener.WorkoutListener
import com.squareup.picasso.Picasso

class WorkoutViewHolder(
    private val viewBinding: ListWorkoutBinding,
    private val workoutListener: WorkoutListener

) : RecyclerView.ViewHolder(viewBinding.root) {


    fun bind(workoutModel: WorkoutModel) {
        viewBinding.tvNameArticles.text = articlesModel.description
        Picasso.get().load(Uri.parse(articlesModel.image)).into(viewBinding.ivImageArticles)


        viewBinding.ivImageArticles.setOnClickListener {
            articlesListener.onElementSelected(

            )
        }
    }
}