package com.volynkin.nasaimageandvideolibrary.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ViewModel : ViewModel() {

    private val repository = Repository
    private val listLiveData = MutableLiveData<List<NASAItem>>()
    private val urlLiveData = MutableLiveData<String>()
    private val isLoadingLiveData = MutableLiveData(false)

    val url: LiveData<String>
        get() = urlLiveData

    val list: LiveData<List<NASAItem>>
        get() = listLiveData

    val isLoading: LiveData<Boolean>
        get() = isLoadingLiveData

    fun search(text: String) {
        isLoadingLiveData.postValue(true)
        repository.checkPreferences(
            text,
            onComplete = { itemList ->
                isLoadingLiveData.postValue(false)
                listLiveData.postValue(itemList.items)
            }
        )
    }

    fun searchUrl(type: String, json: String) {
        isLoadingLiveData.postValue(true)
        repository.searchItem(
            type,
            json,
            onComplete = { url ->
                isLoadingLiveData.postValue(false)
                urlLiveData.postValue(url)
            }
        )
    }
}