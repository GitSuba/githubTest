package data

import enums.HogeEnum

data class HogeResult (
    val hogeR1: HogeEnum?,
    val hogeR2: String,
    val hogeRList: List<HogeResultDetail>
)