package amldev.kotlinandroidonlinecourse.data

import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.extensions.ListenerMediaItems
import amldev.kotlinandroidonlinecourse.ui.interfaces.Provider

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/******************************************************************************
 * Created by anartzmugika on 2/1/18.
 ******************************************************************************/



object MediaProvider: Provider {
    // Para devolver de manera asíncrona
    override fun dataAsync(f: ListenerMediaItems) {
        doAsync {
            if (data.isEmpty()) data =  getMediaItemsData()// dataSync("sports")
            uiThread { f(data) }
        }
    }

    // 1. Initialize Media Items
    fun getMediaItemsData() = listOf<MediaItem>(
            MediaItem(1,"System Of A Down - Hypnotize", "https://i.ytimg.com/vi/LoheCz4t2xc/maxresdefault.jpg", "LoheCz4t2xc", MediaItem.Type.VIDEO),
            MediaItem(2,"Red Hot Chili Peppers - Californication", "https://i.pinimg.com/originals/b0/e5/a8/b0e5a853982347a33455ccfc0a67cecb.jpg", "YlUKcNNmywk", MediaItem.Type.VIDEO),
            MediaItem(3,"En Tol Sarmiento - Ametsetan", "http://entolsarmiento.com/wp-content/uploads/2014/11/portada.jpg", "LtDx3hb-KwI"),
            MediaItem(4, "Hesian: Zerotik", "https://i.ytimg.com/vi/E2lD-vp7n-I/maxresdefault.jpg", "G5SWPS9po74", MediaItem.Type.AUDIO),
            MediaItem(5,"Rev Theory - Hell Yeah", "https://i.ytimg.com/vi/XGLvPYexRJ4/maxresdefault.jpg", "7LuSP4QaXiQ"),
            MediaItem(6,"Egurra Ta Kitto - Lurrikara", "https://i.ytimg.com/vi/4GQPaMzcCcY/hqdefault.jpg", "cnbXjNiimjs", MediaItem.Type.AUDIO))

    private val thumbBase = "http://lorempixel.com/400/400/"

    private var data = emptyList<MediaItem>()

    // Para devolver los datos de manera síncrona (La que usamos)
    private fun dataSync(dataType: String): List<MediaItem> {
        Thread.sleep(500) //Medio segundo para ejecutar la asincronia
        println("Load data....")
        return (1..10).map {
            MediaItem(it, "Title $it", "$thumbBase/$dataType/$it", "iii", if (it % 3 != 0) MediaItem.Type.VIDEO else MediaItem.Type.AUDIO)
        }
    }
}

