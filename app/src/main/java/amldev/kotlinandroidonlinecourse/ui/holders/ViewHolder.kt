package amldev.kotlinandroidonlinecourse.ui.holders

import amldev.kotlinandroidonlinecourse.R
import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.extensions.find
import amldev.kotlinandroidonlinecourse.extensions.loadImageUrl
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.toast

/**
 * Created by anartzmugika on 1/1/18.
 */
class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val imgItem = view.find<ImageView>(R.id.mediaItemImageView)
    val textItem = view.find<TextView>(R.id.mediaItemTextView)
    val videoIndicator = view.find<ImageView>(R.id.videoIndicator)
    val audioIndicator = view.find<ImageView>(R.id.audioIndicator)
    //To define select media item layout with data
    fun bind(item: MediaItem) {
        textItem.text = item.title
        imgItem.loadImageUrl(item.thumbUrl)
        videoIndicator.visibility = when(item.type) {
            MediaItem.Type.PHOTO -> View.GONE
            MediaItem.Type.VIDEO -> View.VISIBLE
        }

        audioIndicator.visibility = when(item.type) {
            MediaItem.Type.PHOTO -> View.VISIBLE
            MediaItem.Type.VIDEO -> View.GONE
        }
        itemView.setOnClickListener { imgItem.context.toast("Click in image item ${item.title}") }
    }
}