package amldev.kotlinandroidonlinecourse.ui.activities.main.di

/**
 * Created by anartzmugika on 7/1/18.
 */
import amldev.kotlinandroidonlinecourse.ui.activities.main.MainActivity
import dagger.Subcomponent
import javax.inject.Singleton

@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}