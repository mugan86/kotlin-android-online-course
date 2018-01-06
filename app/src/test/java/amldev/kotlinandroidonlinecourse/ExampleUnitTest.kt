package amldev.kotlinandroidonlinecourse

import amldev.kotlinandroidonlinecourse.data.addition
import android.app.Activity
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }

    @Test
    fun additionInfixCheck() {
        assertEquals(12, 6 addition 6)
    }
}