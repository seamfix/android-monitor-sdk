package com.seamfix.appmonitor.login.local.dao

import androidx.annotation.Keep
import androidx.lifecycle.LiveData
import androidx.room.*
import com.seamfix.appmonitor.login.model.LoginAttempt

@Keep
@Dao
interface LoginAttemptDao {

    @Insert
    suspend fun save(attempt: LoginAttempt)

    @Query("SELECT * FROM login_attempt WHERE id LIKE :id")
    fun get(id: Int): LiveData<LoginAttempt?>

    @Query("SELECT * FROM login_attempt WHERE id LIKE :id")
    suspend fun getSynchronously(id: Int): LoginAttempt?

    @Query("SELECT * FROM login_attempt")
    suspend fun getAllSynchronously(): List<LoginAttempt>?

    @Update
    suspend fun update(attempt: LoginAttempt)

    @Delete
    suspend fun delete(attempt: LoginAttempt)
}