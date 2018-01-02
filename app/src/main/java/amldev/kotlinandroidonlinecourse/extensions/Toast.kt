package amldev.kotlinandroidonlinecourse.extensions

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.widget.Toast

/**
 * Created by anartzmugika on 1/1/18.
 */

fun Context.toast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}

fun RecyclerView.ViewHolder.toast(message: String) = itemView.context.toast(message, Toast.LENGTH_SHORT)
