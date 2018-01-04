package amldev.kotlinandroidonlinecourse.ui.adapters

import amldev.kotlinandroidonlinecourse.R
import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.extensions.inflate
import amldev.kotlinandroidonlinecourse.ui.holders.ViewHolder
import amldev.kotlinandroidonlinecourse.ui.interfaces.Logger
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlin.properties.Delegates

/**
 * Created by anartzmugika on 1/1/18.
 * Recibe un listado de items para mostrarlo
 */

class MediaAdapter(items: List<MediaItem> = emptyList(), val listener: (MediaItem) -> Unit): RecyclerView.Adapter<ViewHolder>(), Logger {

    // Para ejercicio observable, cuando cambie llamar al notifyDataSetChanged
    //Iniciar con los valores iniciales pasados desde MainActivity
    var items: List<MediaItem> by Delegates.observable(items, { _, _, _ ->
        notifyDataSetChanged()
    })

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = parent.inflate(R.layout.view_media_item)
        return ViewHolder(inflate)
    }
}