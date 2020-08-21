package com.seamfix.appmonitor.login.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.seamfix.appmonitor.login.local.dao.LoginAttemptDao
import com.seamfix.appmonitor.login.model.LoginAttempt


@Database(entities = [LoginAttempt::class], version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun loginAttemptDao(): LoginAttemptDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_monitor"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}