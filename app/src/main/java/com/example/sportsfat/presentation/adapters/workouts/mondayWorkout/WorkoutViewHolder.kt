package com.example.sportsfat.presentation.adapters.workouts.mondayWorkout

import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListWorkoutBinding
import com.example.sportsfat.domain.model.workout.mondayWorkout.MondayWorkoutModel
import com.example.sportsfat.presentation.adapters.workouts.mondayWorkout.listener.WorkoutListener

class WorkoutViewHolder(
    private val viewBinding: ListWorkoutBinding,
    private val workoutListener: WorkoutListener

) : RecyclerView.ViewHolder(viewBinding.root) {


    fun bind(mondayWorkoutModel: MondayWorkoutModel) {
        viewBinding.tvNameWorkout.text = mondayWorkoutModel.name

        viewBinding.details.setOnClickListener {
            workoutListener.onElementSelected(
                mondayWorkoutModel.name
            )
        }

        viewBinding.ibDeleteWorkout.setOnClickListener {
            workoutListener.deleteWorkout(mondayWorkoutModel.name)
        }
    }
}