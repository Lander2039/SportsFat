package com.example.sportsfat.presentation.view.fragments.workouts.listOfWorkouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsfat.databinding.FragmentListWorkoutsBinding
import com.example.sportsfat.presentation.adapters.workouts.listWorkout.ListWorkoutAdapter
import com.example.sportsfat.presentation.adapters.workouts.listWorkout.listener.ListWorkoutListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch

@AndroidEntryPoint
class ListWorkoutsFragment : Fragment(), ListWorkoutListener {

    private val viewModel: ListWorkoutsViewModel by viewModels()

    private lateinit var listWorkoutsAdapter: ListWorkoutAdapter
    private var _viewBinding: FragmentListWorkoutsBinding? = null
    private val viewBinding get() = _viewBinding!!
    private var changeWorkout: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentListWorkoutsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listWorkoutsAdapter = ListWorkoutAdapter(this)

        viewBinding.resListWorkout.layoutManager = LinearLayoutManager(context)
        viewBinding.resListWorkout.adapter = listWorkoutsAdapter

        viewBinding.btnBackAndNeck.setOnClickListener {
            changeWorkout = 10
            changeList(changeWorkout!!)
        }
        viewBinding.btnButtocks.setOnClickListener {
            changeWorkout = 9
            changeList(changeWorkout!!)
        }

        viewModel.msg.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun changeList(changeList: Int) {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.items.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }.collect { flowList ->
                flowList.collect { list ->
                    val listSorted = list.mapNotNull { if (it.image == changeList) it else null }
                    listWorkoutsAdapter.submitList(listSorted)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.getDataArticles()
        }
    }

    override fun onElementSelected(name: String) {

    }

    override fun onAddClicked(name: String, isFavorite: Boolean) {
        viewModel.onAddClicked(name, isFavorite)
    }
}