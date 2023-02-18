package com.example.sportsfat.presentation.view.fragments.workouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sportsfat.databinding.FragmentWorkoutsBinding

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


    }
}