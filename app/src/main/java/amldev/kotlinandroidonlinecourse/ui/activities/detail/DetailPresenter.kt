package amldev.kotlinandroidonlinecourse.ui.activities.detail

import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.ui.interfaces.Provider


/**
 * Created by anartzmugika on 8/1/18.
 */
class DetailPresenter(val view: View, val provider: Provider) {

    interface View {
        fun setTitle(title: String)
        fun setImage(url: String)
        fun setDetailIndicatorVisible(visible: Boolean)
    }

    fun onCreate(itemId: Long) = provider.dataAsync { media ->

        val item = media.find { it.id == itemId.toInt() }

        item?.let {
            view.setTitle(item.title)
            view.setImage(item.thumbUrl)
            view.setDetailIndicatorVisible(item.type == MediaItem.Type.VIDEO)
        }
    }
}