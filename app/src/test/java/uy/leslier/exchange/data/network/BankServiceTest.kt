package uy.leslier.exchange.data.network

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BankServiceTest {

    private lateinit var network: Network

    @Before
    fun setup() {
        network = Network
    }

    @Test
    fun getExchange_returnValues() {

        val latest = runBlocking {
            network.bank.getLatestCurrency().await()
        }
        Assert.assertNotNull(latest.timestamp)
    }
}