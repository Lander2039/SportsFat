package com.example.sportsfat.presentation.view.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.sportsfat.R
import com.example.sportsfat.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private lateinit var viewBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)
        val actionBar = supportActionBar
        actionBar?.hide()

        viewModel.checkUserExists()

        navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView
        ) as NavHostFragment

        navController = navHostFragment.navController

        viewModel.nav.observe(this) {
            navController.setGraph(it)
        }

        navController.addOnDestinationChangedListener(this)

        viewBinding.buttonNavigation.setupWithNavController(navController)

        val btnNav = AppBarConfiguration(
            setOf(R.id.userFragment, R.id.onBoardingFragment)
        )

        NavigationUI.setupActionBarWithNavController(this, navController, btnNav)

        viewModel.visibility.observe(this) {
            viewBinding.buttonNavigation.visibility = it
        }
    }

    private fun getNavGraph(): NavGraph {
        val navGraph = navHostFragment.navController.navInflater.inflate(
            R.navigation.main_graph
        )
        val random = (1..2).random()
        if (random == 1) {
            navGraph.startDestination = R.id.userFragment
        } else {
            navGraph.startDestination = R.id.userFragment
        }
        return navGraph
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        viewModel.destinationChanged(destination)
    }


    override fun onDestroy() {
        super.onDestroy()
        navController.removeOnDestinationChangedListener(this)
    }
}