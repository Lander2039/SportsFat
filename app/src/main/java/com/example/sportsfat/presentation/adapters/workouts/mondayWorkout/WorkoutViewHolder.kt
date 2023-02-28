package com.example.sportsfat.presentation.adapters.workouts.mondayWorkout

import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListWorkoutBinding
import com.example.sportsfat.domain.model.workout.mondayWorkout.MondayWorkoutModel
import com.example.sportsfat.presentation.adapters.workouts.mondayWorkout.listener.WorkoutListener

class WorkoutViewHolder(
    private val viewBinding: ListWorkoutBinding,
    private val workoutListener: WorkoutListener,

    ) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(mondayWorkoutModel: MondayWorkoutModel) {
        viewBinding.tvNameWorkout.text = mondayWorkoutModel.name
        viewBinding.tvNumberApproaches.text = mondayWorkoutModel.approaches
        viewBinding.tvNumberRepetitions.text = mondayWorkoutModel.repetitions
        viewBinding.tvNumberWeight.text = mondayWorkoutModel.weight

        viewBinding.details.setOnClickListener {
            workoutListener.onElementSelected(
                mondayWorkoutModel.name,
                mondayWorkoutModel.description,
                mondayWorkoutModel.implementationOptions,
                mondayWorkoutModel.executionTechnique,
                mondayWorkoutModel.image,
                mondayWorkoutModel.approaches,
                mondayWorkoutModel.repetitions
            )
        }

        viewBinding.ibDeleteWorkout.setOnClickListener {
            workoutListener.deleteWorkout(mondayWorkoutModel.name)
        }

    }
}