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

        viewBinding.details.setOnClickListener {
            workoutListener.onElementSelected(
                mondayWorkoutModel.name,
                mondayWorkoutModel.description,
                mondayWorkoutModel.implementationOptions,
                mondayWorkoutModel.executionTechnique,
                mondayWorkoutModel.image
            )
        }

        viewBinding.ibDeleteWorkout.setOnClickListener {
            workoutListener.deleteWorkout(mondayWorkoutModel.name)
        }

//        viewBinding.details.setOnClickListener {
//            val et = viewBinding.etApproaches.text.toString()
//            workoutListener.addApproachesAndRepetitions(mondayWorkoutModel.name, et)
//            viewBinding.tvText.text = et.toString()
//        }
    }
}