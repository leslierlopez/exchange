package uy.leslier.exchange.data.network

import uy.leslier.exchange.data.database.ExchangeEntry
import uy.leslier.exchange.data.domain.Exchange

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

fun ExchangeNetwork.asDatabaseModel(): ExchangeEntry {
    return ExchangeEntry(
        timestamp,
        rates.USD.buy,
        rates.USD.sell,
        rates.EUR.buy,
        rates.EUR.sell,
        rates.ARS.buy,
        rates.ARS.sell,
        rates.BRL.buy,
        rates.BRL.sell
    )
}

fun ExchangeNetwork.asDomainModel(): Exchange {
    return Exchange(
        timestamp,
        rates.USD.buy,
        rates.USD.sell,
        rates.EUR.buy,
        rates.EUR.sell,
        rates.ARS.buy,
        rates.ARS.sell,
        rates.BRL.buy,
        rates.BRL.sell
    )
}