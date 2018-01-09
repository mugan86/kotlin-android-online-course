package amldev.kotlinandroidonlinecourse.ui.activities.detail.di

/**
 * Created by anartzmugika on 8/1/18.
 */
import amldev.kotlinandroidonlinecourse.ui.activities.detail.DetailActivity
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(DetailModule::class))
interface DetailComponent {
    fun inject(activity: DetailActivity)
}