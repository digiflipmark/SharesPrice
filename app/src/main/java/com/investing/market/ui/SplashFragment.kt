package com.investing.market.ui

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.investing.market.R
import com.investing.market.data.Resource
import com.investing.market.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Timer


@AndroidEntryPoint
class SplashFragment : Fragment() {
    lateinit var binding: FragmentSplashBinding
    private val handler = Handler(Looper.getMainLooper())

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("SplashFragment", "onAttach: " )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("SplashFragment", "onCreate: " )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.e("SplashFragment", "onCreateView: " )
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("SplashFragment", "onViewCreated: " )
        handler.postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }, 2000)
    }


    override fun onStart() {
        super.onStart()
        Log.e("SplashFragment", "onStart: " )
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.e("SplashFragment", "onViewStateRestored: " )
    }

    override fun onResume() {
        super.onResume()
        Log.e("SplashFragment", "onResume: " )
    }

    override fun onPause() {
        super.onPause()
        Log.e("SplashFragment", "onPause: " )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("SplashFragment", "onStart: " )

    }

    override fun onStop() {
        super.onStop()
        Log.e("SplashFragment", "onStop: " )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("SplashFragment", "onDestroyView: " )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("SplashFragment", "onDestroy: " )
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("SplashFragment", "onDetach: " )
    }


}