package amldev.kotlinandroidonlinecourse.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by anartzmugika on 1/1/18.
 */
fun ImageView.loadImageUrl(url: String) = Picasso.with(context).load(url).into(this)
