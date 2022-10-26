package com.practice.mvvmdagger2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.practice.mvvmdagger2.api.QuoteApi
import com.practice.mvvmdagger2.models.QuoteList
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quoteApi: QuoteApi) {
    private var _quoteList = MutableLiveData<QuoteList>()
    val quoteList:LiveData<QuoteList>
    get() = _quoteList

    suspend fun getQuoteList(page:Int){
        val response = quoteApi.getQuotes(page)
        if(response.isSuccessful && response.body() !=  null){
            _quoteList.postValue(response.body())
        }
    }
}