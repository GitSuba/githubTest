package service

import data.HogeCondition
import data.HogeConditionDetail
import data.HogeResult
import data.HogeResultDetail
import enums.HogeEnum
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import repository.HogeRepository
import kotlin.test.assertEquals

class HogeServiceTest {
    private val hogeRepository: HogeRepository = mockk()
    private val hogeService = HogeService(
        hogeRepository = hogeRepository
    )

    @ParameterizedTest
    @MethodSource("updateResultCase")
    @DisplayName("UnitTest:updateResult")
    fun updateResult(
        mockReturn: Map<String, Int>,
        expectedResultNew: HogeResult
    ) {
        val hogeInt = 2

        every {
            hogeRepository.updateResult(any())
        } returns mockReturn

        val actualResultNew = hogeService.updateResult(CONDITION, RESULT_OLD, hogeInt)

        verify {
            hogeRepository.updateResult(hogeInt = hogeInt)
        }
        assertEquals(expectedResultNew, actualResultNew)
    }

    companion object {
        private val CONDITION =
            HogeCondition(
                hogeC1 = "aaa",
                hogeC2 = "bbb",
                hogeCList = listOf(
                    HogeConditionDetail(
                        hogeCD1 = "ccc",
                        hogeCD2 = "ddd",
                    )
                )
            )

        private val RESULT_OLD =
            HogeResult(
                hogeR1 = HogeEnum("mino"),
                hogeR2 = "karubi",
                hogeRList = listOf(
                    HogeResultDetail(
                        hogeRD1 = "harami",
                        hogeRD2 = "horumon",
                    ),
                ),
            )

        @JvmStatic
        fun updateResultCase() = listOf(
            // hogeRD2 = "updateCompleted!"
            Arguments.of(
                mapOf(
                    "ccc" to 0
                ),
                HogeResult(
                    hogeR1 = RESULT_OLD.hogeR1,
                    hogeR2 = "karubi",
                    hogeRList = listOf(
                        HogeResultDetail(
                            hogeRD1 = "harami",
                            hogeRD2 = "updateCompleted!",
                        ),
                    ),
                ),
            ),
            // hogeRD2 = "umm..."
            Arguments.of(
                mapOf(
                    "ccc" to 10
                ),
                HogeResult(
                    hogeR1 = RESULT_OLD.hogeR1,
                    hogeR2 = "karubi",
                    hogeRList = listOf(
                        HogeResultDetail(
                            hogeRD1 = "harami",
                            hogeRD2 = "umm...",
                        ),
                    ),
                ),
            ),
            // hogeRD2 = "updateFailed..."
            Arguments.of(
                mapOf(
                    "ccc" to 20
                ),
                HogeResult(
                    hogeR1 = RESULT_OLD.hogeR1,
                    hogeR2 = "karubi",
                    hogeRList = listOf(
                        HogeResultDetail(
                            hogeRD1 = "harami",
                            hogeRD2 = "updateFailed...",
                        ),
                    ),
                ),
            )
        )
    }
}
