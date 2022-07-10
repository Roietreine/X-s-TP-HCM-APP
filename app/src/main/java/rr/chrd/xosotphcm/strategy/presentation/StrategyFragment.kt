package rr.chrd.xosotphcm.strategy.presentation

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import rr.chrd.xosotphcm.R
import rr.chrd.xosotphcm.databinding.FragmentStrategyBinding
import rr.chrd.xosotphcm.strategy.adapter.StrategyAdapter
import rr.chrd.xosotphcm.strategy.model.StrategyInterface
import rr.chrd.xosotphcm.strategy.model.StrategyModel
import rr.chrd.xosotphcm.viewmodel.ViewModelData

class StrategyFragment : Fragment(), StrategyInterface {

    private var _binding : FragmentStrategyBinding? = null
    private val binding get() = _binding!!
    private var strategyData = ViewModelData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentStrategyBinding.inflate(inflater,container,false)
        val rootView = (binding.root)
        strategyData = ViewModelProvider(this)[ViewModelData::class.java]

        strategyData.stratFun()
        val adpts = StrategyAdapter(this)

        strategyData.strgyNf.observe(viewLifecycleOwner){
            if(it != null){
                adpts.setAdapter(it)
                binding.strategyRecycler.apply {
                    setHasFixedSize(true)
                    layoutManager  = LinearLayoutManager(context)
                    adapter = adpts
                }
            }
        }
        onBackButtonClick()
        return rootView
    }

    override fun onClickItem(data: StrategyModel) {

        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.custom_dialog_show_all)
        dialog.setCancelable(true)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val title = dialog.findViewById<TextView>(R.id.title_view_all)
        val desc = dialog.findViewById<TextView>(R.id.desc_view_all)

        title.text = data.strategyT
        desc.text = data.strategyD

        dialog.show()
    }

    private fun onBackButtonClick(){
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_strategyFragment_to_mainFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}