package com.practice.mvvmdagger2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.mvvmdagger2.models.QuoteList
import com.practice.mvvmdagger2.repository.QuoteRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val respository:QuoteRepository, private val page:Int):ViewModel() {
    lateinit var quoteList:LiveData<QuoteList>
    init {
        viewModelScope.launch {
            respository.getQuoteList(page)
            quoteList = respository.quoteList
        }
    }
}