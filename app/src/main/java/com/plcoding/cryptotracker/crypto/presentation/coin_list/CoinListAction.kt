package com.plcoding.cryptotracker.crypto.presentation.coin_list

import com.plcoding.cryptotracker.crypto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnClick(val coinUi: CoinUi) : CoinListAction
//    data object OnRefresh : CoinListAction
}