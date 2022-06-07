package mapper

import data.HogeCondition

class HogeMapper {
    fun mapping(condition: HogeCondition): List<String> {
        return listOf(
            "harami","horumon"
        )
    }
}
