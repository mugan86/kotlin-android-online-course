package amldev.kotlinandroidonlinecourse.extensions

import amldev.kotlinandroidonlinecourse.domain.models.MediaItem

/**
 * Created by anartzmugika on 9/1/18.
 */
typealias ListenerMediaItem = (MediaItem) -> Unit

//Para hacer nuestros tipos de variables más legibles en el código
typealias ListenerMediaItems = (List<MediaItem>) -> Unit