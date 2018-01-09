package amldev.kotlinandroidonlinecourse

/**
 * Created by anartzmugika on 7/1/18.
 */
import amldev.kotlinandroidonlinecourse.di.AppComponent
import amldev.kotlinandroidonlinecourse.di.AppModule
import amldev.kotlinandroidonlinecourse.di.DaggerAppComponent
import android.app.Application

class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}