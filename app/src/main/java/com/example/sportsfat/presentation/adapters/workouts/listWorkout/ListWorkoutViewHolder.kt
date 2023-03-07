package com.example.sportsfat.presentation.adapters.workouts.listWorkout

import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListWorkoutAddBinding
import com.example.sportsfat.domain.model.workout.WorkoutModel
import com.example.sportsfat.presentation.adapters.workouts.listWorkout.listener.ListWorkoutListener

class ListWorkoutViewHolder(
    private val viewBinding: ListWorkoutAddBinding,
    private val listWorkoutListener: ListWorkoutListener

) : RecyclerView.ViewHolder(viewBinding.root) {


    fun bind(workoutModel: WorkoutModel) {
        viewBinding.tvNameWorkout.text = workoutModel.name

        viewBinding.tvNameWorkout.setOnClickListener {
            listWorkoutListener.onElementSelected(
                workoutModel.name,
                workoutModel.description,
                workoutModel.implementationOptions,
                workoutModel.executionTechnique,
                workoutModel.image
            )

            listWorkoutListener.onAddClicked(workoutModel.name, it.isSelected)
        }

        viewBinding.ivAddWorkout.setOnClickListener {

            listWorkoutListener.onAddClicked(workoutModel.name, it.isSelected)
        }
    }
}