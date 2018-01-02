package amldev.kotlinandroidonlinecourse.ui.holders

import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.extensions.loadImageUrl
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.view_media_item.view.*
import org.jetbrains.anko.toast

/**
 * Created by anartzmugika on 1/1/18.
 */
class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

    //To define select media item layout with data
    fun bind(item: MediaItem) {
        itemView.mediaItemTextView.text = item.title
        itemView.mediaItemImageView.loadImageUrl(item.thumbUrl)
        itemView.videoIndicator.visibility = when(item.type) {
            MediaItem.Type.PHOTO -> View.GONE
            MediaItem.Type.VIDEO -> View.VISIBLE
        }

        itemView.audioIndicator.visibility = when(item.type) {
            MediaItem.Type.PHOTO -> View.VISIBLE
            MediaItem.Type.VIDEO -> View.GONE
        }
        itemView.setOnClickListener { itemView.context.toast("Click in image item ${item.title}") }
    }
}