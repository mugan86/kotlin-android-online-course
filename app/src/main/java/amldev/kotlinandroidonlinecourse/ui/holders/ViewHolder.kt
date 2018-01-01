package amldev.kotlinandroidonlinecourse.ui.holders

import amldev.kotlinandroidonlinecourse.R
import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.toast

/**
 * Created by anartzmugika on 1/1/18.
 */
class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val imgItem = view.findViewById(R.id.mediaItemImageView) as ImageView
    val textItem = view.findViewById(R.id.mediaItemTextView) as TextView
    //To define select media item layout with data
    fun bind(item: MediaItem) {
        textItem.text = item.title
        Picasso.with(imgItem.context).load(item.thumbUrl).into(imgItem)
        itemView.setOnClickListener { imgItem.context.toast("Click in image item ${item.title}") }
    }
}