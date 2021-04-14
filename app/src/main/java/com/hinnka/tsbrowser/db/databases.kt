package com.hinnka.tsbrowser.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hinnka.tsbrowser.App

@Database(entities = [TabInfo::class, SearchHistory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tabDao(): TabDao
    abstract fun searchHistoryDao(): SearchHistoryDao

    companion object {
        val instance: AppDatabase by lazy {
            Room.databaseBuilder(App.instance, AppDatabase::class.java, "app-db-${App.getProcessName()}")
                .build()
        }
    }
}