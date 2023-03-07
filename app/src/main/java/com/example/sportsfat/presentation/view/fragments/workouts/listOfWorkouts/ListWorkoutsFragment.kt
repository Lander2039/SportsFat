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
import com.example.sportsfat.utils.BundleConstants
import com.example.sportsfat.utils.NavHelper.navigateWithBundle
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
            changeWorkout = 1
            changeList(changeWorkout!!)
        }
        viewBinding.btnButtocks.setOnClickListener {
            changeWorkout = 2
            changeList(changeWorkout!!)
        }
        viewBinding.btnPress.setOnClickListener {
            changeWorkout = 3
            changeList(changeWorkout!!)
        }
        viewBinding.btnShoulders.setOnClickListener {
            changeWorkout = 4
            changeList(changeWorkout!!)
        }
        viewBinding.btnHands.setOnClickListener {
            changeWorkout = 5
            changeList(changeWorkout!!)
        }
        viewBinding.btnBreast.setOnClickListener {
            changeWorkout = 6
            changeList(changeWorkout!!)
        }
        viewBinding.btnLegs.setOnClickListener {
            changeWorkout = 7
            changeList(changeWorkout!!)
        }

        viewModel.msg.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {
                val bundle = Bundle()
                bundle.putString(BundleConstants.NAME_WORKOUT, navBundle.name)
                bundle.putString(BundleConstants.DESCRIPTION_WORKOUT, navBundle.description)
                bundle.putString(
                    BundleConstants.IMPLEMENTATION_OPTIONS_WORKOUT,
                    navBundle.implementationOptions
                )
                bundle.putString(
                    BundleConstants.EXECUTION_TECHNIQUE_WORKOUT,
                    navBundle.executionTechnique
                )
                bundle.putInt(BundleConstants.IMAGE_WORKOUT, navBundle.image)
                navigateWithBundle(
                    navBundle.destinationId, bundle
                )
                viewModel.userNavigated()
            }
        }
    }

    private fun changeList(changeList: Int) {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.items.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }.collect { flowList ->
                flowList.collect { list ->
                    val listSorted =
                        list.mapNotNull { if (it.keyWorkout == changeList) it else null }
                    listWorkoutsAdapter.submitList(listSorted)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.getDataArticles()
        }
    }

    override fun onElementSelected(
        name: String,
        description: String,
        implementationOptions: String,
        executionTechnique: String,
        image: Int
    ) {
        viewModel.elementClicked(
            name,
            description,
            implementationOptions,
            executionTechnique,
            image
        )
    }

    override fun onAddClicked(name: String, isFavorite: Boolean) {
        viewModel.onAddClicked(name, isFavorite)
    }
}