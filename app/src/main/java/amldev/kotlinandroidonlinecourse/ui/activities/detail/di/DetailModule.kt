package amldev.kotlinandroidonlinecourse.ui.activities.detail.di

/**
 * Created by anartzmugika on 8/1/18.
 */
import amldev.kotlinandroidonlinecourse.ui.activities.detail.DetailActivity
import amldev.kotlinandroidonlinecourse.ui.activities.detail.DetailPresenter
import amldev.kotlinandroidonlinecourse.ui.interfaces.Provider
import dagger.Module
import dagger.Provides

@Module
class DetailModule(val activity: DetailActivity) {
    @Provides fun provideDetailPresenter(provider: Provider) = DetailPresenter(activity, provider)
}