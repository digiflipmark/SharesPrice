package com.investing.market.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.investing.market.R
import com.investing.market.data.Resource
import com.investing.market.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentDashboardBinding
    private val stockViewmodel: StockViewmodel by viewModels()
    lateinit var stockAdapter: StockAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        stockViewmodel.fetchAllData()

        MobileAds.initialize(requireContext()) {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvStock.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        stockAdapter = StockAdapter()
        binding.rvStock.adapter = stockAdapter

        stockViewmodel.stockList.observe(viewLifecycleOwner) {

            when (it) {
                is Resource.Error -> {

                    binding.progressCircular.isVisible = false
                    Toast.makeText(requireActivity(), "${it.message}", Toast.LENGTH_SHORT)
                        .show()
                }
                is Resource.Loading -> {
                    binding.tvEmpty.isVisible = false
                    binding.progressCircular.isVisible = true
                }
                is Resource.NetworkError -> {

                }
                is Resource.Success -> {
                    binding.progressCircular.isVisible = false
                    if (it.data!!.isNotEmpty()) {
                        binding.tvEmpty.isVisible = false
                        stockAdapter.addiItem(it.data)
                    } else {
                        binding.tvEmpty.isVisible = true

                    }

                }


            }
        }

        // Create an ad request.
        val adRequest = AdRequest.Builder().build()

        // Start loading the ad in the background.
        binding.adView.loadAd(adRequest)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = HomeFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }

    override fun onDestroy() {
        binding.adView.destroy()
        super.onDestroy()
    }

}