package uy.leslier.exchange.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import uy.leslier.exchange.data.database.ExchangeDatabase
import uy.leslier.exchange.data.database.toDomainModel
import uy.leslier.exchange.data.domain.Exchange
import uy.leslier.exchange.data.network.Network
import uy.leslier.exchange.data.network.asDatabaseModel

class ExchangeRepository(private val database: ExchangeDatabase) {

    val exchanges: LiveData<List<Exchange>> =
        Transformations.map(database.exchangeDao.getAllExchanges()) {
            it.toDomainModel()
        }

    suspend fun refresh() {
        withContext(Dispatchers.IO) {
            val currentExchange = Network.bank.getLatestCurrency().await()
            database.exchangeDao.insert(currentExchange.asDatabaseModel())
        }
    }
}