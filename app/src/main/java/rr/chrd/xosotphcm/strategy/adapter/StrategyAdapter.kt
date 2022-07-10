package rr.chrd.xosotphcm.strategy.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rr.chrd.xosotphcm.databinding.StrategyviewBinding
import rr.chrd.xosotphcm.strategy.model.StrategyInterface
import rr.chrd.xosotphcm.strategy.model.StrategyModel
import rr.chrd.xosotphcm.utils.Utilities.Companion.glideImage

class StrategyAdapter (val listener : StrategyInterface) : RecyclerView.Adapter<StrategyAdapter.AdapterHolder>(){

    private var strategyList = emptyList<StrategyModel>()

    class AdapterHolder (val adpts : StrategyviewBinding) : RecyclerView.ViewHolder(adpts.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder = AdapterHolder(
        StrategyviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )
    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
      with(holder){
          with(strategyList[position]){
              adpts.stratTitle.text = this.strategyT
              adpts.stratDesc.text = this.strategyD
              adpts.stratIcon.glideImage(this.stratIcon)
              adpts.stratDesc.ellipsize = TextUtils.TruncateAt.MARQUEE
              adpts.stratDesc.isSelected = true

              adpts.shapeableCardImage.setOnClickListener {
                  listener.onClickItem(this)
              }
          }
      }
    }
    override fun getItemCount(): Int {
        return strategyList.size
    }

    fun setAdapter (setAdapt : List<StrategyModel>){
        this.strategyList = setAdapt
    }


}