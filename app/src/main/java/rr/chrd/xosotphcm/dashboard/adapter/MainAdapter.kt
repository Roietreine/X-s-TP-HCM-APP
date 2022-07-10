package rr.chrd.xosotphcm.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rr.chrd.xosotphcm.dashboard.model.MainFragmentInterface
import rr.chrd.xosotphcm.databinding.MainlayoutPlaceholderBinding

class MainAdapter(
    val dataImg : ArrayList<Int>,
    val listener : MainFragmentInterface
) : RecyclerView.Adapter<MainAdapter.AdapterHolder>() {
    class AdapterHolder (val adpts : MainlayoutPlaceholderBinding) : RecyclerView.ViewHolder(adpts.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder = AdapterHolder(
    MainlayoutPlaceholderBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        holder.adpts.apply {
            carouselPlaceholder.setImageResource(dataImg[position])
            root.setOnClickListener { listener.onItemClick(position) }
        }
    }
    override fun getItemCount(): Int {
       return dataImg.size
    }
}