package com.infoechebo.cryptoinfo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.infoechebo.cryptoinfo.data.local.entity.CoinEntity

@Database(
    entities = [CoinEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CryptoInfoDatabase : RoomDatabase(){
    abstract val dao: CoinDao
}