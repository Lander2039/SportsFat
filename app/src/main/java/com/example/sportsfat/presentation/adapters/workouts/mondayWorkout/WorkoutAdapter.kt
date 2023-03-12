package com.example.sportsfat.presentation.adapters.workouts.mondayWorkout

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListWorkoutBinding
import com.example.sportsfat.domain.model.workout.mondayWorkout.MondayWorkoutModel
import com.example.sportsfat.presentation.adapters.workouts.mondayWorkout.listener.WorkoutListener

class WorkoutAdapter(
    private val workoutListener: WorkoutListener
) : RecyclerView.Adapter<WorkoutViewHolder>() {

    private var listMondayWorkouts = mutableListOf<MondayWorkoutModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<MondayWorkoutModel>) {

        this.listMondayWorkouts.clear()
        this.listMondayWorkouts = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val viewBinding =
            ListWorkoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WorkoutViewHolder(viewBinding, workoutListener)

    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        holder.bind(listMondayWorkouts[position])
    }

    override fun getItemCount(): Int {
        return listMondayWorkouts.size
    }
}
