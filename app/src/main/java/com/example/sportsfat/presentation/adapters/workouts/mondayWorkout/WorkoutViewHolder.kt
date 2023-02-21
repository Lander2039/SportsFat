package com.example.sportsfat.presentation.adapters.workouts.mondayWorkout

import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListWorkoutBinding
import com.example.sportsfat.domain.model.WorkoutModel
import com.example.sportsfat.presentation.adapters.workouts.mondayWorkout.listener.WorkoutListener

class WorkoutViewHolder(
    private val viewBinding: ListWorkoutBinding,
    private val workoutListener: WorkoutListener

) : RecyclerView.ViewHolder(viewBinding.root) {


    fun bind(workoutModel: WorkoutModel) {
        viewBinding.tvNameWorkout.text = workoutModel.name

        viewBinding.details.setOnClickListener {
            workoutListener.onElementSelected(
                workoutModel.name
            )
        }
    }
}