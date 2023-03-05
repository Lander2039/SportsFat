package com.example.sportsfat.presentation.view.fragments.user.dataUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sportsfat.R
import com.example.sportsfat.databinding.FragmentUserDataBinding
import com.example.sportsfat.domain.model.UserModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDataFragment : Fragment() {

    private val viewModel: UserDataViewModel by viewModels()
    private var _viewBinding: FragmentUserDataBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentUserDataBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.userDataShow()

        viewModel.calculateBMI(
            viewBinding.etHeight.text.toString().toDoubleOrNull() ?: 0.0,
            viewBinding.etWeightStart.text.toString().toIntOrNull() ?: 0
        )
        val bmi = viewModel.bmi.toInt()

        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.errorHeight.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }


        viewBinding.btnSave.setOnClickListener {
            viewModel.saveUserDateNew(
                1,
                viewBinding.etName.text.toString(),
                viewBinding.etAge.text.toString().toIntOrNull() ?: 0,
                viewBinding.etHeight.text.toString().toDoubleOrNull() ?: 0.0,
                viewBinding.etWeightStart.text.toString().toIntOrNull() ?: 0,
                viewBinding.etActivityFactor.text.toString().toDoubleOrNull() ?: 0.0,
                0
            )
        }

        viewModel.userData.observe(viewLifecycleOwner) {
            viewBinding.tvResult.text = it.resultWeight.toString()
            viewBinding.etName.setText(it.name)
            viewBinding.etAge.setText(it.age.toString())
            viewBinding.etHeight.setText(it.height.toString())
            viewBinding.etWeightStart.setText(it.weightStart.toString())
            viewBinding.etActivityFactor.setText(it.activityFactor.toString())
        }
    }

}