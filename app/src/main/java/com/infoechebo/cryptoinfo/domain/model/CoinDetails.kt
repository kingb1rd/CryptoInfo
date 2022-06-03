package com.infoechebo.cryptoinfo.domain.model

import com.infoechebo.cryptoinfo.data.remote.dto.Team

data class CoinDetails(
    val description: String,
    val isNew: Boolean,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<Team>
)