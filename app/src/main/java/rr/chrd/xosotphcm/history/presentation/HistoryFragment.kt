package rr.chrd.xosotphcm.history.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import rr.chrd.xosotphcm.R
import rr.chrd.xosotphcm.databinding.FragmentHistoryBinding
import rr.chrd.xosotphcm.history.adapter.HistoryAdapter
import rr.chrd.xosotphcm.viewmodel.ViewModelData


class HistoryFragment : Fragment() {

    private var _binding : FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private var historyData = ViewModelData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHistoryBinding.inflate(inflater,container,false)
        val rootView = (binding.root)
        historyData = ViewModelProvider(this)[ViewModelData::class.java]
        earlyRecyclerCall()
        midRecyclerCall()
        bottomRecyclerCall()
        onBackButtonClick()

        return rootView
    }

    private fun earlyRecyclerCall(){
        historyData.earlyHistoFun()
        val adpts = HistoryAdapter()
        historyData.rHstryNf.observe(viewLifecycleOwner){
            if (it != null){
                adpts.setAdapter(it)
                binding.earlyHistoryRecycler.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = adpts

                }
            }
        }
    }

    private fun midRecyclerCall(){
        historyData.midHistoFun()
        val adapts = HistoryAdapter()
        historyData.mddlHstryNf.observe(viewLifecycleOwner){
            if (it != null){
                adapts.setAdapter(it)
                binding.midHistoryRecycler.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = adapts
                }
            }
        }
    }

    private fun bottomRecyclerCall(){
        historyData.earlyLotteryFun()
        val adpts = HistoryAdapter()
        historyData.rlyLttryHstryNf.observe(viewLifecycleOwner){
            if (it != null){
                adpts.setAdapter(it)
                binding.earlyLotteryHistoryRecycler.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = adpts
                }
            }
        }
    }

    private fun onBackButtonClick(){
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_historyFragment_to_mainFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}