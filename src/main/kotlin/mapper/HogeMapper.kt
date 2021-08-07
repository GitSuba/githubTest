package mapper

import data.HogeCondition
import data.HogeResultDetail

class HogeMapper {
    fun mapping(condition: HogeCondition): List<String> {
        return listOf(
            "harami","horumon"
        )
    }
}