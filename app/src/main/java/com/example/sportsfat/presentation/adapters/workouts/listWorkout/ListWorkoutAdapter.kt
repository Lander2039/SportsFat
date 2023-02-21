package com.example.sportsfat.presentation.adapters.workouts.listWorkout

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListWorkoutAddBinding
import com.example.sportsfat.domain.model.workout.WorkoutModel
import com.example.sportsfat.presentation.adapters.workouts.listWorkout.listener.ListWorkoutListener

class ListWorkoutAdapter(
    private val listWorkoutListener: ListWorkoutListener
) : RecyclerView.Adapter<ListWorkoutViewHolder>() {

    private var listWorkouts = mutableListOf<WorkoutModel>()


    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<WorkoutModel>) {

        this.listWorkouts.clear()
        this.listWorkouts = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListWorkoutViewHolder {
        val viewBinding =
            ListWorkoutAddBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListWorkoutViewHolder(viewBinding, listWorkoutListener)
    }

    override fun onBindViewHolder(holder: ListWorkoutViewHolder, position: Int) {
        holder.bind(listWorkouts[position])
    }

    override fun getItemCount(): Int {
        return listWorkouts.size
    }
}