package amldev.kotlinandroidonlinecourse.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by anartzmugika on 1/1/18.
 */
fun ImageView.loadImageUrl(url: String) = Picasso.get().load(url).into(this)

// For example R.drawable.hello
fun ImageView.loadImageDrawable(image: Int) = Picasso.get().load(image).into(this)
