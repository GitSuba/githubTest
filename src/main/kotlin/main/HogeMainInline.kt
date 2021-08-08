package main

import kotlin.random.Random

inline fun multiply(times: Int, body:(Int) -> Unit) {
    for(index in 0 until times){
        body(index)
    }
}

// ランダムに生成した数字で止まるようにする（範囲：0～10）
fun equalRandom(num: Int) =
    Random.nextInt(10) == num

fun main(){
    multiply(10){// 無名関数の引数 it:Int
        println(it*it)
        if(equalRandom(it)) return
    }
}

// ↑この関数は、以下のようにラムダ式の中身がインライン展開されている
// fun main() {
//    for (index in 0 until 10) {
//        println(it*it)
//        if (isFavorite(index)) return
//    }
//}
