package com.lagravam.praktikandoproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val name = MutableLiveData("")
    val lastname = MutableLiveData("")
    val counter = MutableLiveData(0)


    fun addAction() {
        counter.value = counter.value?.plus(1)
    }

    fun minusAction() {
        if (counter.value!! > 0) {
            counter.value = counter.value?.minus(1)
        }
    }


}