package uy.leslier.exchange.data.database

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ExchangeDatabaseTest {

    private lateinit var db: ExchangeDatabase

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context, ExchangeDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetExchange() {
        val exchange = ExchangeEntry(123L, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9)
        db.exchangeDao.insert(exchange)
        val today = db.exchangeDao.getLast()
        assertEquals(today?.timestamp, 123L)
    }
}