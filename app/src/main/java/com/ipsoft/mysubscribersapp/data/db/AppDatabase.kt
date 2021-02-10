package com.ipsoft.mysubscribersapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ipsoft.mysubscribersapp.data.db.dao.SubscriberDao
import com.ipsoft.mysubscribersapp.data.db.entity.SubscriberEntity

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    My Subscribers App
 *  Date:       09/02/2021
 */
@Database(entities = [SubscriberEntity::class], version = DB_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract val subscriberDao: SubscriberDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance: AppDatabase? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    ).build()
                }
                return instance
            }
        }
    }
}