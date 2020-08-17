package com.amol.jare.fittrapp.viewModel

import com.amol.jare.fittrapp.model.ListRepository

class ListViewModel : BaseViewModel() {

    fun fetchRepoList() {
        try {
            dataLoading.value = true
            ListRepository.getInstance().getRepoList { isSuccess, response ->
                dataLoading.value = false
                if (isSuccess) {
                    if (response != null) {
                    }
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}