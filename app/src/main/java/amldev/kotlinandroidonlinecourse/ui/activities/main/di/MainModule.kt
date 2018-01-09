package amldev.kotlinandroidonlinecourse.ui.activities.main.di

/**
 * Created by anartzmugika on 7/1/18.
 */

import amldev.kotlinandroidonlinecourse.ui.activities.main.MainActivity
import amldev.kotlinandroidonlinecourse.ui.activities.main.MainPresenter
import amldev.kotlinandroidonlinecourse.ui.interfaces.Provider
import dagger.Module
import dagger.Provides

@Module
class MainModule(val activity: MainActivity) {
    @Provides fun provideMainPresenter(provider: Provider) = MainPresenter(activity, provider)
}