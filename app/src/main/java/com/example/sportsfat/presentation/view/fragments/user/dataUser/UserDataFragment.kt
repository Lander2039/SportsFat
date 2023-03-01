package com.example.sportsfat.presentation.view.fragments.user.dataUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sportsfat.R
import com.example.sportsfat.databinding.FragmentUserBinding
import com.example.sportsfat.databinding.FragmentUserDataBinding
import com.example.sportsfat.presentation.view.fragments.user.UserViewModel
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
}