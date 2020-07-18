package uy.leslier.exchange.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exchange_table")
data class ExchangeEntry(
    @PrimaryKey(autoGenerate = false)
    var timestamp: Long,

    @ColumnInfo(name = "usd_buy")
    var usdBuy: Double,

    @ColumnInfo(name = "usd_sell")
    var usdSell: Double,

    @ColumnInfo(name = "eur_buy")
    var eurBuy: Double,

    @ColumnInfo(name = "eur_sell")
    var eurSell: Double,

    @ColumnInfo(name = "ars_buy")
    var arsBuy: Double,

    @ColumnInfo(name = "ars_sell")
    var arsSell: Double,

    @ColumnInfo(name = "brl_buy")
    var brlBuy: Double,

    @ColumnInfo(name = "brl_sell")
    var brlSell: Double
)