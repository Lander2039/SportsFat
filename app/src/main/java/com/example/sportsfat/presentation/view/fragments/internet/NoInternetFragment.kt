package com.example.sportsfat.presentation.view.fragments.internet

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.sportsfat.R
import com.example.sportsfat.databinding.FragmentNoInternetBinding
import com.example.sportsfat.utils.NavHelper.navigate


class NoInternetFragment : Fragment() {

    private var _viewBinding: FragmentNoInternetBinding? = null
    private val viewBinding get() = _viewBinding!!
    private val viewModel: NoInternetViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentNoInternetBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.root.setBackgroundColor(Color.WHITE)
        Glide.with(this)
            .asGif()
            .load(R.drawable.internet)
            .into(viewBinding.ivInternet)

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                navigate(it)
            }
        }
        viewBinding.btnTry.setOnClickListener {
            viewModel.openUser()
            viewModel.finishPerformed()
        }
    }

}