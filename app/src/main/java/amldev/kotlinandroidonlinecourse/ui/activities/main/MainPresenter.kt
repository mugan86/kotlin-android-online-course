package amldev.kotlinandroidonlinecourse.ui.activities.main

import amldev.kotlinandroidonlinecourse.data.Filter
import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.ui.interfaces.Provider

/**
 * Created by anartzmugika on 7/1/18.
 */
class MainPresenter(val view: View, val provider: Provider) {

    interface View {
        fun updateData(media: List<MediaItem>)
        fun showProgress()
        fun hideProgress()
        fun navigateTo(id: Long)
    }

    fun onCreate() {
        filterClicked(Filter.None())
    }

    fun filterClicked(filter: Filter) {
        view.showProgress()
        provider.dataAsync { media ->

            val result = when (filter) {
                is Filter.None -> media
                is Filter.ByType -> media.filter { it.type == filter.type }
            }

            view.updateData(result)
            view.hideProgress()
        }
    }

    fun itemClicked(item: MediaItem) {
        view.navigateTo(item.id.toLong())
    }

}