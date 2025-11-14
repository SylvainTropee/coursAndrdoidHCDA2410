package com.example.mod4demo2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel : ViewModel() {

    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()
    //val counter : StateFlow<Int> = _counter


}