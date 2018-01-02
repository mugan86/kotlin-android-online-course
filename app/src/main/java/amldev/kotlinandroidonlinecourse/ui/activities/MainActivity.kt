package amldev.kotlinandroidonlinecourse.ui.activities

import amldev.kotlinandroidonlinecourse.R
import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.extensions.toast
import amldev.kotlinandroidonlinecourse.ui.adapters.MediaAdapter
import amldev.kotlinandroidonlinecourse.ui.interfaces.Logger
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Logger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("Load Media Items!!")
        loadList()
    }

    private fun loadList() {

        // 1. Initialize Media Items
        val itemsData = listOf<MediaItem>(
                MediaItem("System Of A Down - Hypnotize", "https://i.ytimg.com/vi/LoheCz4t2xc/maxresdefault.jpg", "LoheCz4t2xc", MediaItem.Type.VIDEO),
                MediaItem("Red Hot Chili Peppers - Californication", "https://i.pinimg.com/originals/b0/e5/a8/b0e5a853982347a33455ccfc0a67cecb.jpg", "YlUKcNNmywk", MediaItem.Type.VIDEO),
                MediaItem("En Tol Sarmiento - Ametsetan", "http://entolsarmiento.com/wp-content/uploads/2014/11/portada.jpg", "LtDx3hb-KwI"),
                MediaItem("Hesian: Zerotik", "https://i.ytimg.com/vi/E2lD-vp7n-I/maxresdefault.jpg", "G5SWPS9po74", MediaItem.Type.AUDIO),
                MediaItem("Rev Theory - Hell Yeah", "https://i.ytimg.com/vi/XGLvPYexRJ4/maxresdefault.jpg", "7LuSP4QaXiQ"),
                MediaItem("Egurra Ta Kitto - Lurrikara", "https://i.ytimg.com/vi/4GQPaMzcCcY/hqdefault.jpg", "cnbXjNiimjs", MediaItem.Type.AUDIO))

        // 2. set layoutManger
        recycler.layoutManager = LinearLayoutManager(this)
        // 3. create an adapter
        val mAdapter = MediaAdapter(itemsData)
        // 4. set adapter
        recycler.adapter = mAdapter
        // 5. set item animator to DefaultAnimator
        recycler.itemAnimator = DefaultItemAnimator()
    }
}
