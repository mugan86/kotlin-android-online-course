package amldev.kotlinandroidonlinecourse.di

/**
 * Created by anartzmugika on 7/1/18.
 */
import amldev.kotlinandroidonlinecourse.App
import amldev.kotlinandroidonlinecourse.ui.activities.detail.di.DetailComponent
import amldev.kotlinandroidonlinecourse.ui.activities.detail.di.DetailModule
import amldev.kotlinandroidonlinecourse.ui.activities.main.di.MainComponent
import amldev.kotlinandroidonlinecourse.ui.activities.main.di.MainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)
    fun plus(homeModule: MainModule): MainComponent
    fun plus(detailModule: DetailModule): DetailComponent
}