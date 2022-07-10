package rr.chrd.xosotphcm.dashboard

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import rr.chrd.xosotphcm.R
import rr.chrd.xosotphcm.dashboard.adapter.MainAdapter
import rr.chrd.xosotphcm.dashboard.model.MainFragmentInterface
import rr.chrd.xosotphcm.databinding.FragmentMainBinding
import rr.chrd.xosotphcm.utils.PagerTransformer
import rr.chrd.xosotphcm.utils.Utilities.Companion.dataImg

class MainFragment : Fragment(), View.OnClickListener, MainFragmentInterface {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentMainBinding.inflate(inflater,container,false)
        val rootView = (binding.root)
        carouselTransform()
        return rootView

    }

    private fun carouselTransform() {
        binding.pagerItem.apply {
            val pageLimit = dataImg.size
            adapter = MainAdapter(dataImg,this@MainFragment)
            offscreenPageLimit = pageLimit
            setPageTransformer(PagerTransformer(pageLimit))
        }
        binding.previousPicture.setOnClickListener {
            carouselSetState(isNext = false)
        }
        binding.nextPicture.setOnClickListener {
            carouselSetState(isNext = true)
        }
    }

    private fun carouselSetState(isNext: Boolean){
        binding.pagerItem.apply {
            when(isNext) {
                true -> currentItem += 1
                false -> currentItem -= 1
            }
        }
    }

    override fun onItemClick(position: Int) {
        when(position) {
            0 ->{
                findNavController().navigate(R.id.action_mainFragment_to_terminologyFragment)
            }

            1 ->{
                findNavController().navigate(R.id.action_mainFragment_to_historyFragment)
            }

            2 ->{
                findNavController().navigate(R.id.action_mainFragment_to_strategyFragment)
            }

            else -> {

            }
        }
    }

    override fun onClick(v: View?) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}