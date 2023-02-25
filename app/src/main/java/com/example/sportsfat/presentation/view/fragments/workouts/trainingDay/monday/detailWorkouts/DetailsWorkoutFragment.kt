package com.example.sportsfat.presentation.view.fragments.workouts.trainingDay.monday.detailWorkouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sportsfat.databinding.FragmentDetailsWorkoutBinding
import com.example.sportsfat.presentation.view.fragments.workouts.trainingDay.MondayViewModel
import com.example.sportsfat.utils.BundleConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsWorkoutFragment : Fragment() {

    private val viewModel: MondayViewModel by viewModels()

    private var _viewBinding: FragmentDetailsWorkoutBinding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDetailsWorkoutBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        bundle?.let { safeBundle ->
            val name = safeBundle.getString(BundleConstants.NAME_WORKOUT)
            val description = safeBundle.getString(BundleConstants.DESCRIPTION_WORKOUT)
            val implementationOptions =
                safeBundle.getString(BundleConstants.IMPLEMENTATION_OPTIONS_WORKOUT)
            val executionTechnique =
                safeBundle.getString(BundleConstants.EXECUTION_TECHNIQUE_WORKOUT)
            val image = safeBundle.getInt(BundleConstants.IMAGE_WORKOUT)


            viewBinding.tvNameWorkout.text = name
            viewBinding.tvTextDescription.text = description
            viewBinding.tvTextImplementationOptions.text = implementationOptions
            viewBinding.tvTextExecutionTechnique.text = executionTechnique
//            viewBinding.ivImageWorkout.setBackgroundResource(image)
        }

    }
}