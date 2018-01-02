package amldev.kotlinandroidonlinecourse.ui.interfaces

import android.util.Log

/**********
 * Created by anartzmugika on 1/1/18.
 */
interface Logger {
    val tag: String
        get() = javaClass.simpleName

    fun d(message: String) = Log.d(tag, message)
}