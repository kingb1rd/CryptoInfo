package com.infoechebo.cryptoinfo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.infoechebo.cryptoinfo.data.local.entity.CoinEntity

@Dao
interface CoinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoins(coins: List<CoinEntity>)

    @Query("DELETE FROM coinentity")
    suspend fun deleteCoins()

    @Query("SELECT * FROM coinentity")
    suspend fun getCoins(): List<CoinEntity>
}