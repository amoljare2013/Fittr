package com.amol.jare.fittrapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel() : ViewModel() {

    val dataLoading = MutableLiveData<Boolean>().apply { value = false }

}