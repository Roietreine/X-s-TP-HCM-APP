package rr.chrd.xosotphcm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import rr.chrd.xosotphcm.history.model.HistoryModel
import rr.chrd.xosotphcm.strategy.model.StrategyModel
import rr.chrd.xosotphcm.terminology.model.TerminologyModel
import rr.chrd.xosotphcm.utils.StaticData.Companion.earlyHistoryDesc
import rr.chrd.xosotphcm.utils.StaticData.Companion.earlyLotteriesDesc
import rr.chrd.xosotphcm.utils.StaticData.Companion.middleHistoryDesc
import rr.chrd.xosotphcm.utils.StaticData.Companion.stratDesc
import rr.chrd.xosotphcm.utils.StaticData.Companion.stratTitle
import rr.chrd.xosotphcm.utils.StaticData.Companion.termiDesc
import rr.chrd.xosotphcm.utils.StaticData.Companion.termiTitle
import rr.chrd.xosotphcm.utils.Utilities
import rr.chrd.xosotphcm.utils.Utilities.Companion.histoIcon
import rr.chrd.xosotphcm.utils.Utilities.Companion.stratIcon

class ViewModelData : ViewModel() {

    private var termiList = ArrayList<TerminologyModel>()
    private var termiInfo = MutableLiveData<List<TerminologyModel>>()
    val trmNf : LiveData<List<TerminologyModel>>
        get() = termiInfo
    private var termiError = CoroutineExceptionHandler { _, _ ->
        termiInfo.postValue(null)
    }

    fun termiFun(): MutableLiveData<List<TerminologyModel>> {
        viewModelScope.launch(termiError + Dispatchers.IO){
            for(n in termiTitle.indices){
                termiList.add(TerminologyModel(termiTitle[n],termiDesc[n]))
            }
            termiInfo.postValue(termiList)
        }
        return termiInfo
    }

    private var earlyHistoryList = ArrayList<HistoryModel>()
    private var earlyHistoryInfo = MutableLiveData<List<HistoryModel>>()
    val rHstryNf : LiveData<List<HistoryModel>>
    get() = earlyHistoryInfo

    private var historyError = CoroutineExceptionHandler { _, _ ->
        earlyHistoryInfo.postValue(null)
    }

    fun earlyHistoFun() : MutableLiveData<List<HistoryModel>>{
        viewModelScope.launch( historyError + Dispatchers.IO){
            for (n in earlyHistoryDesc.indices){
                earlyHistoryList.add(HistoryModel(histoIcon[n],earlyHistoryDesc[n]))
            }
            earlyHistoryInfo.postValue(earlyHistoryList)
        }
        return earlyHistoryInfo
    }
    private var middleHistoryList = ArrayList<HistoryModel>()
    private var middleHistoryInfo = MutableLiveData<List<HistoryModel>>()
    val mddlHstryNf : LiveData<List<HistoryModel>>
    get() = middleHistoryInfo

    private var middleHistoryError = CoroutineExceptionHandler { _, _ ->
        middleHistoryInfo.postValue(null)
    }
    fun midHistoFun() : MutableLiveData<List<HistoryModel>>{
        viewModelScope.launch( middleHistoryError + Dispatchers.IO){
            for (n in middleHistoryDesc.indices){
                middleHistoryList.add(HistoryModel(histoIcon[n],middleHistoryDesc[n]))
            }
            middleHistoryInfo.postValue(middleHistoryList)
        }
        return middleHistoryInfo
    }

    private var earlyLotteryHistoryList = ArrayList<HistoryModel>()
    private var earlyLotteryHistoryInfo = MutableLiveData<List<HistoryModel>>()
    val rlyLttryHstryNf : LiveData<List<HistoryModel>>
        get() = earlyLotteryHistoryInfo

    private var earlyLotteryHistoryError = CoroutineExceptionHandler { _, _ ->
        earlyLotteryHistoryInfo.postValue(null)
    }
    fun earlyLotteryFun() : MutableLiveData<List<HistoryModel>>{
        viewModelScope.launch( earlyLotteryHistoryError + Dispatchers.IO){
            for (n in earlyLotteriesDesc.indices){
                earlyLotteryHistoryList.add(HistoryModel(histoIcon[n],earlyLotteriesDesc[n]))
            }
            earlyLotteryHistoryInfo.postValue(earlyLotteryHistoryList)
        }
        return earlyLotteryHistoryInfo
    }

    private var strategyList = ArrayList<StrategyModel>()
    private var strategyInfo = MutableLiveData<List<StrategyModel>>()
    val strgyNf : LiveData<List<StrategyModel>>
    get() = strategyInfo

    private var strategyError = CoroutineExceptionHandler { _, _ ->
        strategyInfo.postValue(null)
    }

    fun stratFun() : MutableLiveData<List<StrategyModel>>{
        viewModelScope.launch(strategyError + Dispatchers.IO){
            for (n in stratTitle.indices){
                strategyList.add(StrategyModel(stratTitle[n], stratDesc[n],stratIcon[n]))
            }
            strategyInfo.postValue(strategyList)
        }
        return strategyInfo
    }
}