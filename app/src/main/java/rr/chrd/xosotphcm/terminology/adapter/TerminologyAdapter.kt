package rr.chrd.xosotphcm.terminology.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rr.chrd.xosotphcm.databinding.TerminologyviewBinding
import rr.chrd.xosotphcm.terminology.model.TerminologyInterface
import rr.chrd.xosotphcm.terminology.model.TerminologyModel

class TerminologyAdapter (val listener : TerminologyInterface) : RecyclerView.Adapter<TerminologyAdapter.AdapterHolder>() {

    private var terminologyList = emptyList<TerminologyModel>()

    class AdapterHolder(val adpts: TerminologyviewBinding) : RecyclerView.ViewHolder(adpts.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder =
        AdapterHolder(
            TerminologyviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        with(holder) {
            with(terminologyList[position]) {

                adpts.termiTitle.text = this.termiT
                adpts.termiDesc.text = this.termiD
                adpts.termiDesc.ellipsize = TextUtils.TruncateAt.MARQUEE
                adpts.termiDesc.isSelected = true
                adpts.termiCard.setOnClickListener {
                    listener.onClickButton(this)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return terminologyList.size
    }

    fun setAdapter (setAdapt : List<TerminologyModel>){
        this.terminologyList = setAdapt
    }
}