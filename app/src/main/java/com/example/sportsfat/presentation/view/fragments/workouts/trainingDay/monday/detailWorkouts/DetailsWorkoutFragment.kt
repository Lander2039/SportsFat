package com.example.sportsfat.presentation.view.fragments.workouts.trainingDay.monday.detailWorkouts

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sportsfat.databinding.FragmentDetailsWorkoutBinding
import com.example.sportsfat.utils.BundleConstants
import com.example.sportsfat.utils.BundleConstants.NAME_WORKOUT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsWorkoutFragment : Fragment() {

    private val viewModel: DetailsWorkoutViewModel by viewModels()

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

            viewBinding.btnDescription.setOnClickListener {
                if (viewBinding.tvTextDescription.visibility == View.VISIBLE) {
                    viewBinding.tvTextDescription.visibility = View.INVISIBLE
                    viewBinding.tvTextDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP, 0.1f)
                    viewBinding.tvTextDescription.text = ""
                } else {
                    viewBinding.tvTextDescription.visibility = View.VISIBLE
                    viewBinding.tvTextDescription.text = description
                    viewBinding.tvTextDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                }
            }
            viewBinding.btnFeatures.setOnClickListener {
                if (viewBinding.tvTextImplementationOptions.visibility == View.VISIBLE) {
                    viewBinding.tvTextImplementationOptions.visibility = View.INVISIBLE
                    viewBinding.tvTextImplementationOptions.setTextSize(TypedValue.COMPLEX_UNIT_SP, 0.1f)
                    viewBinding.tvTextImplementationOptions.text = implementationOptions
                } else {
                    viewBinding.tvTextImplementationOptions.visibility = View.VISIBLE
                    viewBinding.tvTextImplementationOptions.text = implementationOptions
                    viewBinding.tvTextImplementationOptions.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                }
            }
            viewBinding.btnTechnique.setOnClickListener {
                if (viewBinding.tvTextExecutionTechnique.visibility == View.VISIBLE) {
                    viewBinding.tvTextExecutionTechnique.visibility = View.INVISIBLE
                    viewBinding.tvTextExecutionTechnique.setTextSize(TypedValue.COMPLEX_UNIT_SP, 0.1f)
                } else {
                    viewBinding.tvTextExecutionTechnique.visibility = View.VISIBLE
                    viewBinding.tvTextExecutionTechnique.text = executionTechnique
                    viewBinding.tvTextExecutionTechnique.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                }
            }
            viewBinding.tvNameWorkout.text = name
            viewBinding.tvTextDescription.text = description
            viewBinding.ivImageWorkout.setBackgroundResource(image)
        }

        viewBinding.btnSave.setOnClickListener {
            if (bundle != null) {
                viewModel.addApproaches(
                    bundle.getString(NAME_WORKOUT)!!,
                    viewBinding.etTextApproaches.text.toString(),
                    viewBinding.etTextRepetitions.text.toString(),
                    viewBinding.etTextOperatingWeight.text.toString()
                )
            }
        }
        viewModel.msg.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }
}
