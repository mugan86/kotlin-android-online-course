package amldev.kotlinandroidonlinecourse.data

import amldev.kotlinandroidonlinecourse.domain.models.MediaItem

/**
 * Created by anartzmugika on 2/1/18.
 */
// 1. Initialize Media Items
fun getMediaItemsData() = listOf<MediaItem>(
        MediaItem("System Of A Down - Hypnotize", "https://i.ytimg.com/vi/LoheCz4t2xc/maxresdefault.jpg", "LoheCz4t2xc", MediaItem.Type.VIDEO),
        MediaItem("Red Hot Chili Peppers - Californication", "https://i.pinimg.com/originals/b0/e5/a8/b0e5a853982347a33455ccfc0a67cecb.jpg", "YlUKcNNmywk", MediaItem.Type.VIDEO),
        MediaItem("En Tol Sarmiento - Ametsetan", "http://entolsarmiento.com/wp-content/uploads/2014/11/portada.jpg", "LtDx3hb-KwI"),
        MediaItem("Hesian: Zerotik", "https://i.ytimg.com/vi/E2lD-vp7n-I/maxresdefault.jpg", "G5SWPS9po74", MediaItem.Type.AUDIO),
        MediaItem("Rev Theory - Hell Yeah", "https://i.ytimg.com/vi/XGLvPYexRJ4/maxresdefault.jpg", "7LuSP4QaXiQ"),
        MediaItem("Egurra Ta Kitto - Lurrikara", "https://i.ytimg.com/vi/4GQPaMzcCcY/hqdefault.jpg", "cnbXjNiimjs", MediaItem.Type.AUDIO))

private val thumbBase = "http://lorempixel.com/400/400/sports/"

fun getMediaItems() =  (1..12).map { MediaItem("Title $it", "${ thumbBase }$it", "iii", if (it % 3 != 0) MediaItem.Type.VIDEO else MediaItem.Type.AUDIO) }
