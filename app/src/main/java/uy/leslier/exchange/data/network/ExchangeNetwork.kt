package uy.leslier.exchange.data.network

data class ExchangeNetwork(
    val timestamp: Long,
    val rates: RatesNetwork
)

data class RatesNetwork(
    val ARS: RateNetwork,
    val BRL: RateNetwork,
    val EUR: RateNetwork,
    val USD: RateNetwork
)

data class RateNetwork(
    val sell: Double,
    val buy: Double
)