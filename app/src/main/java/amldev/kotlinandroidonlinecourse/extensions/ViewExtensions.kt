package amldev.kotlinandroidonlinecourse.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by anartzmugika on 1/1/18.
 */
fun ViewGroup.inflate(resource: Int): View {
   return LayoutInflater.from(context).inflate(resource, this, false)
}