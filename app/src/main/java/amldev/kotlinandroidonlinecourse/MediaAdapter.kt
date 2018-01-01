package amldev.kotlinandroidonlinecourse

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.toast

/**
 * Created by anartzmugika on 1/1/18.
 * Recibe un listado de items para mostrarlo
 */

class MediaAdapter(val items: List<MediaItem>): RecyclerView.Adapter<MediaAdapter.ViewHolder>(), Logger {
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.view_media_item, parent, false)
        return ViewHolder(inflate)
    }

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
}