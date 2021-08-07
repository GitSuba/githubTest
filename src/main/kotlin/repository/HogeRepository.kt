package repository

class HogeRepository {
    fun updateResult(hogeInt: Int): Map<String,Int> {
        return mapOf(
            "ccc" to hogeInt * 10,
        )
    }
}