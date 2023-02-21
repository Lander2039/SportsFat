package com.example.sportsfat.presentation.view.fragments.workouts.trainingDay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsfat.databinding.FragmentMondayBinding
import com.example.sportsfat.presentation.adapters.workouts.mondayWorkout.WorkoutAdapter
import com.example.sportsfat.presentation.adapters.workouts.mondayWorkout.listener.WorkoutListener
import com.example.sportsfat.utils.NavHelper.navigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch

@AndroidEntryPoint
class MondayFragment : Fragment(), WorkoutListener {

    private lateinit var workoutAdapter: WorkoutAdapter
    private val viewModel: MondayViewModel by viewModels()

    private var _viewBinding: FragmentMondayBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentMondayBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        workoutAdapter = WorkoutAdapter(this)

        viewBinding.resWorkout.layoutManager = LinearLayoutManager(context)
        viewBinding.resWorkout.adapter = workoutAdapter



        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.items.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }.collect { flowList ->
                flowList.collect { list ->
                    workoutAdapter.submitList(list)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.getDataArticles()
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                navigate(it)
            }
        }
        viewBinding.floatingActionButton.setOnClickListener {
            viewModel.openListWorkouts()
            viewModel.finishPerformed()
        }
    }

    override fun onElementSelected(name: String) {

    }
}