package com.infoechebo.cryptoinfo.domain.model

import com.infoechebo.cryptoinfo.data.remote.dto.TeamMember

data class CoinDetails(
    val rank: Int,
    val name: String,
    val symbol: String,
    val description: String,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)