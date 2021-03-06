package com.ipsoft.mysubscribersapp.repository

import com.ipsoft.mysubscribersapp.data.db.entity.SubscriberEntity

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    My Subscribers App
 *  Date:       09/02/2021
 */

interface SubscriberRepository {
    suspend fun insertSubscriber(name: String, email: String): Long
    suspend fun updateSubscriber(id: Long, name: String, email: String)
    suspend fun deleteSubscriber(id: Long)
    suspend fun deleteAllSubscribers()
    suspend fun getAllSubscribers(): List<SubscriberEntity>
}