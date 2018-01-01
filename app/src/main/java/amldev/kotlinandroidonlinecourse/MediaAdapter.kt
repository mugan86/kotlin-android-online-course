package amldev.kotlinandroidonlinecourse

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by anartzmugika on 1/1/18.
 * Recibe un listado de items para mostrarlo
 */

class MediaItem

class MediaAdapter(val items: List<MediaItem>): RecyclerView.Adapter<MediaAdapter.ViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.view_media_item, parent, false)
        return ViewHolder(inflate)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        //To define select media item layout with data
        fun bind(item: MediaItem) {

        }
    }
}