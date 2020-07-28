package uy.leslier.exchange.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import uy.leslier.exchange.data.domain.Exchange

@Entity(tableName = "exchange_table")
data class ExchangeEntry(
    @PrimaryKey(autoGenerate = false)
    val timestamp: Long,

    @ColumnInfo(name = "usd_buy")
    val usdBuy: Double,

    @ColumnInfo(name = "usd_sell")
    val usdSell: Double,

    @ColumnInfo(name = "eur_buy")
    val eurBuy: Double,

    @ColumnInfo(name = "eur_sell")
    val eurSell: Double,

    @ColumnInfo(name = "ars_buy")
    val arsBuy: Double,

    @ColumnInfo(name = "ars_sell")
    val arsSell: Double,

    @ColumnInfo(name = "brl_buy")
    val brlBuy: Double,

    @ColumnInfo(name = "brl_sell")
    val brlSell: Double
)

fun ExchangeEntry.toDomainModel(): Exchange {
    return Exchange(
        timestamp,
        usdBuy,
        usdSell,
        eurBuy,
        eurSell,
        arsBuy,
        arsSell,
        brlBuy,
        brlSell
    )
}

fun List<ExchangeEntry>.toDomainModel(): List<Exchange> {
    return map {
        Exchange(
            it.timestamp,
            it.usdBuy,
            it.usdSell,
            it.eurBuy,
            it.eurSell,
            it.arsBuy,
            it.arsSell,
            it.brlBuy,
            it.brlSell
        )
    }
}