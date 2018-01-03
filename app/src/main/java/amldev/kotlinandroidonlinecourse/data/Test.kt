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