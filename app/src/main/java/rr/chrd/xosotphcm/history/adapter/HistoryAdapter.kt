package rr.chrd.xosotphcm.history.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rr.chrd.xosotphcm.databinding.HistoryViewBinding
import rr.chrd.xosotphcm.history.model.HistoryModel
import rr.chrd.xosotphcm.utils.Utilities.Companion.glideImage


class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.AdapterHolder>(){

    private var  historyList = emptyList<HistoryModel>()
    var currentposition = -1

    class AdapterHolder (val adpts : HistoryViewBinding): RecyclerView.ViewHolder(adpts.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder = AdapterHolder(
        HistoryViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        with(holder){
            with(historyList[position]){

                adpts.earlyHistoryDesc.text = this.historyD
                adpts.historyIcon.glideImage(this.dataIcon)
                adpts.expandLayout.visibility = View.GONE
               if(currentposition == position) {
                adpts.expandLayout.visibility = View.VISIBLE
                }

                adpts.constraintId.setOnClickListener {
                    currentposition = position
                    notifyDataSetChanged()
                }

                }

        }
    }

    override fun getItemCount(): Int {
     return historyList.size
    }
    fun setAdapter (setAdapt : List<HistoryModel>){
        this.historyList = setAdapt
    }

}