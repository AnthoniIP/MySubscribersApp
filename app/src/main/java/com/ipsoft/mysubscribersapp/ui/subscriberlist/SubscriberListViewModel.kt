package com.ipsoft.mysubscribersapp.ui.subscriberlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipsoft.mysubscribersapp.data.db.entity.SubscriberEntity
import com.ipsoft.mysubscribersapp.repository.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberListViewModel(
	private val repository: SubscriberRepository
) : ViewModel() {

    private val _allSuscribersEvent = MutableLiveData<List<SubscriberEntity>>()
    val allSubscribersEvent: LiveData<List<SubscriberEntity>>
        get() = _allSuscribersEvent

    fun getSubscribers() = viewModelScope.launch {
        _allSuscribersEvent.postValue(repository.getAllSubscribers())
    }

}