package amldev.kotlinandroidonlinecourse.ui.interfaces

import amldev.kotlinandroidonlinecourse.domain.models.MediaItem

/**
 * Created by anartzmugika on 2/1/18.
 */
interface OnMediaClickListener {
    fun onClick(mediaItem: MediaItem)
}