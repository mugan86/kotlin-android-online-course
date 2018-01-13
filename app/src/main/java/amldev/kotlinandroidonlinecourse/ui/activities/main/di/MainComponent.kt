package amldev.kotlinandroidonlinecourse.ui.activities.main.di

/**
 * Created by anartzmugika on 7/1/18.
 */
import amldev.kotlinandroidonlinecourse.ui.activities.main.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}