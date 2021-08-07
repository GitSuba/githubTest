package repository

import data.HogeCondition
import data.HogeConditionDetail
import data.HogeResult
import data.HogeResultDetail
import mapper.HogeMapper
import java.time.LocalTime

/**
 * HogeResultに値を入れる
 */
class FugaRepository(
    private val hogeMapper: HogeMapper,
) {
    fun fetchFuge(condition: HogeCondition): HogeResult {
        val hoge1 = "aaa"
        val hoge2 = "bbb"
        val hoge3 = "ccc"
        val hoge4 = "ddd"
        HogeCondition(
            hogeC1 = hoge1,
            hogeC2 = hoge2,
            hogeCList = listOf(
                HogeConditionDetail(
                    hogeCD1 = hoge3,
                    hogeCD2 = hoge4,
                )
            )
        )
        val hogeList: List<String> = hogeMapper.mapping(condition)
        val fuga1 = "mino"
        val fuga2 = "karubi"
        return HogeResult(
            hogeR1 = fuga1,
            hogeR2 = fuga2,
            hogeRList = listOf(
                HogeResultDetail(
                    hogeRD1 = hogeList[0],
                    hogeRD2 = hogeList[1],
                )
            ),
        )
    }
}