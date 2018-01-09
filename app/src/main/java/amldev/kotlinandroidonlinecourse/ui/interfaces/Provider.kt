package amldev.kotlinandroidonlinecourse.ui.interfaces

import amldev.kotlinandroidonlinecourse.extensions.ListenerMediaItems

/**
 * Created by anartzmugika on 9/1/18.
 */
interface Provider {
    fun dataAsync(f: ListenerMediaItems)
}