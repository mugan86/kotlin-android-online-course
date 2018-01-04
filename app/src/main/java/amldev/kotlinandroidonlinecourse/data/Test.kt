package amldev.kotlinandroidonlinecourse.data

import amldev.kotlinandroidonlinecourse.domain.models.MediaItem

/**
 * Created by anartzmugika on 2/1/18.
 */
//Lambdas
fun test() {
    val sum = {a: Int, b: Int -> a + b}
    applyOp(2,3, sum)
    val mul = {a: Int, b: Int -> a + b}
    applyOp(2,3, mul)

    //Sin usar Lambda
    /*doAsync(20, object: Callback {
        override fun onCallBack(result: String) {
            print(result)
        }
    })*/

    //Esto sería lo mismo que lo de arriba pero usando Lambdas
    doAsync(20) { result -> print(result)}
}

fun applyOp(x: Int, y: Int, f: (Int, Int)->Int): Int = f(x,y)

fun doAsync(x: Int, callback: (String) -> Unit) {
    callback("finished")
}

// Collections examples
fun collections(items: List<MediaItem>) {
    val urlsList: List<String> =
            items.filter { it.type == MediaItem.Type.VIDEO}
            .sortedBy { it.title }
            .map { it.thumbUrl}

    val urlList_ = items.toMutableList()

    val mutableList: MutableList<Int> = mutableListOf(2,3,5)
    mutableList.add(3)
    mutableList.remove(2)

    items.forEach { println(it.thumbUrl) }
}

fun collectionsAndRanges() {
    for (i in 1..4) print(i) // print 1,2,3,4

    (1..4).forEach(::print) // print 1,2,3,4

    (1 until 4).forEach(::print) // print 1,2,3

    (4 downTo 1).forEach(::print)

    val x: String = "c"

    val y = when(x) {
        in ("a".."e") -> 1
        in ("f".."z") -> 2
        else -> 3
    }
}

fun infixFunctions() {
    println (5 addition 5) // = 5 + 5 = 10
}

infix fun Int.addition(number: Int) = this + number


// Tratamiento de nulos

fun nullTest() {
    val myInt : Int ? = null

    val myLong: Long = myInt?.toLong() ?: 0L

    //Equivalente a myLong

    val myLong2: Long = if (myInt != null) myInt.toLong() else 0L
}