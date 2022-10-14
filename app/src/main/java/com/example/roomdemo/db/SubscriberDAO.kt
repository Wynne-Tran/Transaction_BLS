package com.example.roomdemo.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface SubscriberDAO {

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber) : Long

//    @Insert
//    fun insertSubscriber2(subscriber: Subscriber) : Long
//
//    @Insert
//    fun insertSubscriber3(subscriber: List<Subscriber>) : List<Long>

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscribers() : LiveData<List<Subscriber>>
}