package amldev.kotlinandroidonlinecourse.ui.adapters

import amldev.kotlinandroidonlinecourse.R
import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.extensions.inflate
import amldev.kotlinandroidonlinecourse.extensions.toast
import amldev.kotlinandroidonlinecourse.ui.holders.ViewHolder
import amldev.kotlinandroidonlinecourse.ui.interfaces.Logger
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by anartzmugika on 1/1/18.
 * Recibe un listado de items para mostrarlo
 */

class MediaAdapter(val items: List<MediaItem>): RecyclerView.Adapter<ViewHolder>(), Logger {
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.toast("Create ViewHolder to render media items")
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = parent.inflate(R.layout.view_media_item)
        return ViewHolder(inflate)
    }
}