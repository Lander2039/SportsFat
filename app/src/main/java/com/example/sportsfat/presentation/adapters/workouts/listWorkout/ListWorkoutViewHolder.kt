package com.example.sportsfat.presentation.adapters.workouts.listWorkout

import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListWorkoutAddBinding
import com.example.sportsfat.domain.model.WorkoutModel
import com.example.sportsfat.presentation.adapters.workouts.listWorkout.listener.ListWorkoutListener

class ListWorkoutViewHolder(
    private val viewBinding: ListWorkoutAddBinding,
    private val listWorkoutListener: ListWorkoutListener

) : RecyclerView.ViewHolder(viewBinding.root) {


    fun bind(workoutModel: WorkoutModel) {
        viewBinding.tvNameWorkout.text = workoutModel.name

        viewBinding.ivDetailsWorkout.setOnClickListener {
            listWorkoutListener.onElementSelected(
                workoutModel.name
            )
        }
    }
}