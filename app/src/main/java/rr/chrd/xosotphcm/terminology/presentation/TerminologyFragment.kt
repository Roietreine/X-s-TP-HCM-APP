package rr.chrd.xosotphcm.terminology.presentation

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import rr.chrd.xosotphcm.R
import rr.chrd.xosotphcm.databinding.FragmentTerminologyBinding
import rr.chrd.xosotphcm.terminology.adapter.TerminologyAdapter
import rr.chrd.xosotphcm.terminology.model.TerminologyInterface
import rr.chrd.xosotphcm.terminology.model.TerminologyModel
import rr.chrd.xosotphcm.viewmodel.ViewModelData


class TerminologyFragment : Fragment(), TerminologyInterface {

    private var _binding : FragmentTerminologyBinding? = null
    private val binding get() =_binding!!
    private var termiData = ViewModelData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentTerminologyBinding.inflate(inflater,container,false)
        val rootView = (binding.root)
        termiData = ViewModelProvider(this) [ViewModelData::class.java]

        termiData.termiFun()
        val adpts = TerminologyAdapter(this)

        termiData.trmNf.observe(viewLifecycleOwner){
            if (it != null){
                adpts.setAdapter(it)
                binding.terminologyRecycler.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = adpts
                }
            }
        }
        onBackButtonClick()
        return rootView
    }

    override fun onClickButton(data: TerminologyModel) {

        val dialog = Dialog(requireContext())
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.custom_dialog_show_all)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val title = dialog.findViewById<TextView>(R.id.title_view_all)
        val desc = dialog.findViewById<TextView>(R.id.desc_view_all)
        title.text = data.termiT
        desc.text = data.termiD

        dialog.show()
    }

    private fun onBackButtonClick(){
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_terminologyFragment_to_mainFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}