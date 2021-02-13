package com.ipsoft.mysubscribersapp.repository

import com.ipsoft.mysubscribersapp.data.db.dao.SubscriberDao
import com.ipsoft.mysubscribersapp.data.db.entity.SubscriberEntity

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    My Subscribers App
 *  Date:       09/02/2021
 */

class DatabaseDataSource(
    private val subscriberDao: SubscriberDao
) : SubscriberRepository {
    override suspend fun insertSubscriber(name: String, email: String): Long {
        val subscriber = SubscriberEntity(
            name = name,
            email = email
        )
        return subscriberDao.insert(subscriber)

    }

    override suspend fun updateSubscriber(id: Long, name: String, email: String) {
        val subscriber = SubscriberEntity(
            id = id,
            name = name,
            email = email
        )
        subscriberDao.update(subscriber)
    }

    override suspend fun deleteSubscriber(id: Long) {
        subscriberDao.delete(id)
    }

    override suspend fun deleteAllSubscribers() {
        subscriberDao.deleteAll()
    }

    override suspend fun getAllSubscribers(): List<SubscriberEntity> {
        return subscriberDao.getAll()
    }
}