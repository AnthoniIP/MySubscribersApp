package com.ipsoft.mysubscribersapp.ui.subscriberlist

import androidx.lifecycle.ViewModel
import com.ipsoft.mysubscribersapp.repository.SubscriberRepository

class SubscriberListViewModel(
		private val repository : SubscriberRepository
	) : ViewModel() {

	val allSubscribersEvent = repository.getAllSubscribers()
    
}