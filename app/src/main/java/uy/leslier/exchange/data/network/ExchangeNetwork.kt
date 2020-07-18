package uy.leslier.exchange.data.network

import java.math.BigDecimal

data class ExchangeNetwork(
    val timestamp: BigDecimal,
    val rates: RatesNetwork
)

data class RatesNetwork(
    val ARS: RateNetwork,
    val BRL: RateNetwork,
    val EUR: RateNetwork,
    val USD: RateNetwork
)

data class RateNetwork(
    val sell: BigDecimal,
    val buy: BigDecimal
)