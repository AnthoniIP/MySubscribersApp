package com.ipsoft.mysubscribersapp.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ipsoft.mysubscribersapp.data.db.TABLE_NAME
import kotlinx.parcelize.Parcelize

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    My Subscribers App
 *  Date:       09/02/2021
 */
@Parcelize
@Entity(tableName = TABLE_NAME)
data class SubscriberEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val email: String
) : Parcelable