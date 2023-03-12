package com.example.sportsfat.presentation.view.fragments.workouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sportsfat.R
import com.example.sportsfat.databinding.FragmentWorkoutsBinding
import com.example.sportsfat.domain.model.workout.TrainingDayModel
import com.example.sportsfat.utils.NavHelper.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutsFragment : Fragment() {

    private val viewModel: WorkoutsViewModel by viewModels()

    private var _viewBinding: FragmentWorkoutsBinding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentWorkoutsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.trainingDayShow()

        fun openDialog(id: Int, day: Int) {
            val input = EditText(context)
            val dialog = AlertDialog.Builder(requireActivity())
                .setTitle(getString(R.string.ChangeNameWorkout))
                .setMessage(getString(R.string.EnterNewWorkoutName))
                .setView(input)
                .setPositiveButton(getString(R.string.Ok)) { dialog, which ->
                    val dayNew = input.text.toString()
                    when (day) {
                        1 -> {
                            viewModel.saveTrainingDay1(id,dayNew)
                            viewBinding.tvNameTrainingDay1.text = dayNew
                        }
                        2 -> {
                            viewModel.saveTrainingDay2(id,dayNew)
                            viewBinding.tvNameTrainingDay2.text = dayNew
                        }
                        3 -> {
                            viewModel.saveTrainingDay3(id,dayNew)
                            viewBinding.tvNameTrainingDay3.text = dayNew
                        }
                        4 -> {
                            viewModel.saveTrainingDay4(id,dayNew)
                            viewBinding.tvNameTrainingDay4.text = dayNew
                        }
                        5 -> {
                            viewModel.saveTrainingDay5(id,dayNew)
                            viewBinding.tvNameTrainingDay5.text = dayNew
                        }
                        6 -> {
                            viewModel.saveTrainingDay6(id,dayNew)
                            viewBinding.tvNameTrainingDay6.text = dayNew
                        }
                        7 -> {
                            viewModel.saveTrainingDay7(id,dayNew)
                            viewBinding.tvNameTrainingDay7.text = dayNew
                        }
                    }
                }
                .setNegativeButton(getString(R.string.Cansel)) { dialog, which ->
                }
            dialog.create()
            dialog.show()
        }
            viewBinding.iwEditNameTrainingDay1.setOnClickListener {
                openDialog(1,1)
            }

            viewBinding.iwEditNameTrainingDay2.setOnClickListener {
                openDialog(1,2)
            }
            viewBinding.iwEditNameTrainingDay3.setOnClickListener {
                openDialog(1,3)
            }
            viewBinding.iwEditNameTrainingDay4.setOnClickListener {
                openDialog(1,4)
            }
            viewBinding.iwEditNameTrainingDay5.setOnClickListener {
                openDialog(1,5)
            }
            viewBinding.iwEditNameTrainingDay6.setOnClickListener {
                openDialog(1,6)
            }
            viewBinding.iwEditNameTrainingDay7.setOnClickListener {
                openDialog(1,7)
            }

        viewModel.trainingDay.observe(viewLifecycleOwner){
            viewBinding.tvNameTrainingDay1.text =it.firstDay
            viewBinding.tvNameTrainingDay2.text =it.secondDay
            viewBinding.tvNameTrainingDay3.text =it.theThirdDay
            viewBinding.tvNameTrainingDay4.text =it.fourthDay
            viewBinding.tvNameTrainingDay5.text =it.fifthDay
            viewBinding.tvNameTrainingDay6.text =it.sixthDay
            viewBinding.tvNameTrainingDay7.text =it.seventhDay
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                navigate(it)
            }
        }
        viewBinding.tvNameTrainingDay1.setOnClickListener {
            viewModel.openMonday()
            viewModel.finishPerformed()
        }
//        viewBinding.tvNameTrainingDay2.setOnClickListener {
//            viewModel.openNoInternet()
//            viewModel.finishPerformed()
//        }
    }
}