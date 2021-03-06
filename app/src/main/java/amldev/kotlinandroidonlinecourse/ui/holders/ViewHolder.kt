package amldev.kotlinandroidonlinecourse.ui.holders

import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.extensions.loadImageUrl
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.view_media_item.view.*

/**
 * Created by anartzmugika on 1/1/18.
 */
class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

    //To define select media item layout with data
    fun bind(item: MediaItem) {
        with(itemView) {
            mediaItemTextView.text = item.title
            mediaItemImageView.loadImageUrl(item.thumbUrl)
            videoIndicator.visibility = when(item.type) {
                MediaItem.Type.AUDIO -> View.GONE
                MediaItem.Type.VIDEO -> View.VISIBLE
            }

            audioIndicator.visibility = when(item.type) {
                MediaItem.Type.AUDIO -> View.VISIBLE
                MediaItem.Type.VIDEO -> View.GONE
            }
        }

    }
}