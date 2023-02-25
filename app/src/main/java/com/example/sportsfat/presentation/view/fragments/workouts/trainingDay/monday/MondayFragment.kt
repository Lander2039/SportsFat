package com.example.sportsfat.presentation.view.fragments.workouts.trainingDay.monday

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
import com.example.sportsfat.presentation.view.fragments.workouts.trainingDay.MondayViewModel
import com.example.sportsfat.utils.BundleConstants
import com.example.sportsfat.utils.NavHelper.navigate
import com.example.sportsfat.utils.NavHelper.navigateWithBundle
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
        }

        viewModel.msg.observe(viewLifecycleOwner){
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
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
        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {
                val bundle = Bundle()
                bundle.putString(BundleConstants.NAME_WORKOUT, navBundle.name)
                bundle.putString(BundleConstants.DESCRIPTION_WORKOUT, navBundle.description)
                bundle.putString(BundleConstants.IMPLEMENTATION_OPTIONS_WORKOUT, navBundle.implementationOptions)
                bundle.putString(BundleConstants.EXECUTION_TECHNIQUE_WORKOUT, navBundle.executionTechnique)
                bundle.putInt(BundleConstants.IMAGE_WORKOUT, navBundle.image)

                navigateWithBundle(
                    navBundle.destinationId, bundle
                )
                viewModel.userNavigated()
            }
        }
    }

    override fun onElementSelected(name: String, description: String, implementationOptions: String, executionTechnique: String,image: Int) {
        viewModel.elementClicked(name, description,implementationOptions, executionTechnique,image)
    }

    override fun deleteWorkout(name: String) {
        viewModel.deleteMondayWorkout(name)
    }

    override fun addApproachesAndRepetitions(name: String, approaches: String) {
        viewModel.addApproaches(name,approaches)
    }

}