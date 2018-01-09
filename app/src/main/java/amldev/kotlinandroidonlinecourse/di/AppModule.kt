package amldev.kotlinandroidonlinecourse.di

import amldev.kotlinandroidonlinecourse.App
import amldev.kotlinandroidonlinecourse.data.MediaProvider
import amldev.kotlinandroidonlinecourse.ui.interfaces.Provider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by anartzmugika on 7/1/18.
 */
@Module
class AppModule(val app: App) {
    @Provides @Singleton fun provideApp() = app
    @Provides
    @Singleton
    fun provideMediaProvider(): Provider = MediaProvider
}