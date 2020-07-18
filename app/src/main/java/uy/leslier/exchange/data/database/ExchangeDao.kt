package uy.leslier.exchange.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExchangeDao {

    @Insert
    fun insert(exchangeEntry: ExchangeEntry)

    @Update
    fun update(exchangeEntry: ExchangeEntry)

    @Query("SELECT * from exchange_table WHERE timestamp = :key")
    fun get(key: Long): ExchangeEntry?

    @Query("DELETE FROM exchange_table")
    fun clear()

    @Query("SELECT * FROM exchange_table ORDER BY timestamp DESC")
    fun getAllExchanges(): LiveData<List<ExchangeEntry>>

    @Query("SELECT * FROM exchange_table ORDER BY timestamp DESC LIMIT 1")
    fun getToday(): ExchangeEntry?

}