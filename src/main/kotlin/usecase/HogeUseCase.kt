package usecase

import data.HogeCondition
import data.HogeResult
import repository.FugaRepository
import service.HogeService
import kotlin.random.Random

class HogeUseCase(
    private val fugaRepository: FugaRepository,
    private val hogeService: HogeService,
) {
    fun execute(condition: HogeCondition): HogeResult{
        val result = fugaRepository.fetchFuge(condition)
        val hogeInt = Random.nextInt(3)
        return hogeService.updateResult(condition,result,hogeInt)
    }
}