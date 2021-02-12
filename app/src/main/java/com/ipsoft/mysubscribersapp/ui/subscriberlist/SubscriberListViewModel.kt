package com.ipsoft.mysubscribersapp.ui.subscriberlist

import androidx.lifecycle.ViewModel

class SubscriberListViewModel(
		private val repository : SuscriberRepository
	) : ViewModel() {

	val allSubscribersEvent = repository.getAllSubscribers()
    
}