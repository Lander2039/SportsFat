package com.example.sportsfat.presentation.view.fragments.workouts.listOfWorkouts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sportsfat.R
import com.example.sportsfat.databinding.FragmentListWorkoutsBinding
import com.example.sportsfat.databinding.FragmentWorkoutsBinding
import com.example.sportsfat.presentation.view.fragments.workouts.WorkoutsViewModel


class ListWorkoutsFragment : Fragment() {

    private val viewModel: ListWorkoutsViewModel by viewModels()

    private var _viewBinding: FragmentListWorkoutsBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentListWorkoutsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}