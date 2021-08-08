package service

import constants.HogeConstants
import data.HogeCondition
import data.HogeResult
import data.HogeResultDetail
import repository.HogeRepository

class HogeService(
    private val hogeRepository: HogeRepository,
) {
    fun updateResult(condition: HogeCondition, resultOld: HogeResult, hogeInt: Int): HogeResult {
        // 取得したデータをhogeMapとして返却する
        val hogeMap: Map<String, Int> = hogeRepository.updateResult(hogeInt)
        var new = resultOld
        // 取得したマップの値を使って、リザルトをアップデートする
        condition.hogeCList.forEach { conditionDetail ->
            val judge: Int = hogeMap[conditionDetail.hogeCD1] ?: HogeConstants.HOGE1
            new = resultOld.copy(
                hogeRList = resultOld.hogeRList.map {
                    it.copy(
                        hogeRD2 = when {
                            judge < 1 -> "updateCompleted!"
                            judge in 2..10 -> "umm..."
                            else -> "updateFailed..."
                        }
                    )
                }
            )
        }
        return new
    }
}