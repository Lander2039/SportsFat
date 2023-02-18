package com.example.sportsfat.presentation.adapters.workouts

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListArticlesBinding
import com.example.sportsfat.databinding.ListWorkoutBinding
import com.example.sportsfat.domain.model.ArticlesModel
import com.example.sportsfat.domain.model.WorkoutModel
import com.example.sportsfat.presentation.adapters.workouts.listener.WorkoutListener

class WorkoutAdapter(
    private val workoutListener: WorkoutListener
) : RecyclerView.Adapter<WorkoutViewHolder>() {

    private var listWorkouts = mutableListOf<WorkoutModel>()


    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<WorkoutModel>) {
        this.listWorkouts.clear()
        this.listWorkouts = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val viewBinding =
            ListWorkoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WorkoutViewHolder(viewBinding, workoutListener)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        holder.bind(listWorkouts[position])
    }

    override fun getItemCount(): Int {
        return  listWorkouts.size
    }
}
