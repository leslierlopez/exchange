package uy.leslier.exchange.data.domain

data class Exchange(
    val timestamp: Long,
    val usdBuy: Double,
    val usdSell: Double,
    val eurBuy: Double,
    val eurSell: Double,
    val arsBuy: Double,
    val arsSell: Double,
    val brlBuy: Double,
    val brlSell: Double
)