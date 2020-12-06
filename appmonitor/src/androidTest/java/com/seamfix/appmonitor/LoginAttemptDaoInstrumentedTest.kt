package com.seamfix.appmonitor

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.seamfix.appmonitor.login.local.AppDatabase
import com.seamfix.appmonitor.login.local.dao.LoginAttemptDao
import com.seamfix.appmonitor.login.model.LoginAttempt
import com.seamfix.appmonitor.login.model.enums.LoginMethod
import com.seamfix.appmonitor.login.model.enums.LoginMode
import com.seamfix.appmonitor.login.model.enums.LoginStatus
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import org.junit.Assert.*


@RunWith(AndroidJUnit4::class)
class LoginAttemptDaoInstrumentedTest {

    private lateinit var db: AppDatabase
    private lateinit var loginAttemptDao: LoginAttemptDao

    private val loginAttempt = LoginAttempt(
        "jeffemuveyan@gmail.com",
        100000,
        "NA",
        LoginStatus.SUCCESS,
        "NA",
        LoginMode.ONLINE,
        LoginMethod.EMAIL)


    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
        loginAttemptDao = db.loginAttemptDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }


    @Test
    @Throws(Exception::class)
    fun canWriteAndRead() = runBlocking{
        //write
        db.loginAttemptDao().save(loginAttempt)

        //confirm
        val savedLoginAttempts = db.loginAttemptDao().getAllSynchronously()
        assert(savedLoginAttempts != null)
        assert(savedLoginAttempts!!.size == 1)

        //read
        val aSavedLoginAttempt = db.loginAttemptDao().getSynchronously(1)//Since we set autoGenerate = true,
        //the first item we add to the database will start from 1 instead of 0.

        assert(aSavedLoginAttempt != null)
        assert(aSavedLoginAttempt!!.username == loginAttempt.username)
    }


    @Test
    @Throws(Exception::class)
    fun delete() = runBlocking {

        //write
        db.loginAttemptDao().save(loginAttempt)

        //confirm
        val savedLoginAttempt = db.loginAttemptDao().getSynchronously(1)
        assert(savedLoginAttempt!!.username == loginAttempt.username)

        var savedLoginAttempts = db.loginAttemptDao().getAllSynchronously()
        assert(savedLoginAttempts!!.size == 1)

        //delete
        db.loginAttemptDao().delete(savedLoginAttempt)

        savedLoginAttempts = db.loginAttemptDao().getAllSynchronously()

        //confirm
        assert(savedLoginAttempts!!.isEmpty())
    }
}