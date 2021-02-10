package com.ipsoft.mysubscribersapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ipsoft.mysubscribersapp.data.db.TABLE_NAME
import com.ipsoft.mysubscribersapp.data.db.entity.SubscriberEntity

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    My Subscribers App
 *  Date:       09/02/2021
 */
@Dao
interface SubscriberDao {
    @Insert
    suspend fun insert(subscriber: SubscriberEntity): Long

    @Update
    suspend fun update(subscriber: SubscriberEntity)

    @Query("DELETE FROM $TABLE_NAME WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll(): LiveData<List<SubscriberEntity>>
}