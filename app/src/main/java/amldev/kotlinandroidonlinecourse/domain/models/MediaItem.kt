package amldev.kotlinandroidonlinecourse.domain.models

/**
 * Created by anartzmugika on 1/1/18.
 */
data class MediaItem(val id: Int, val title: String, val thumbUrl: String, val videoId: String = "", val type: Type = Type.VIDEO) {
    enum class Type { VIDEO, AUDIO }
}
