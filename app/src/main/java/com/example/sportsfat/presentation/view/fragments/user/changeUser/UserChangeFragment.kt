package com.example.sportsfat.presentation.view.fragments.user.changeUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sportsfat.databinding.FragmentUserChangeBinding
import com.example.sportsfat.utils.NavHelper.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserChangeFragment : Fragment() {

    private val viewModel: UserChangeViewModel by viewModels()
    private var _viewBinding: FragmentUserChangeBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentUserChangeBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnSave.setOnClickListener {
            viewModel.saveUserWeightStart(
                1,
                viewBinding.etWeight.text.toString().toIntOrNull() ?: 0
            )
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                navigate(it)
            }
        }
    }
}