package amldev.kotlinandroidonlinecourse.data

import amldev.kotlinandroidonlinecourse.domain.models.MediaItem

/**
 * Created by anartzmugika on 5/1/18.
 */
sealed class Filter {
    class None: Filter()
    class ByType(val type: MediaItem.Type): Filter()
}