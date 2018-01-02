package amldev.kotlinandroidonlinecourse.data

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

interface Callback {
    fun onCallBack(result: String)
}

fun doAsync(x: Int, callback: (String) -> Unit) {
    callback.invoke("finished")
}