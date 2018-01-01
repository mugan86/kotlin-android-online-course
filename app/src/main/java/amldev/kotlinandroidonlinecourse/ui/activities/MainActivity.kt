package amldev.kotlinandroidonlinecourse.ui.activities

import amldev.kotlinandroidonlinecourse.R
import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
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
        loadList()
    }

    private fun loadList() {


        val itemsData = listOf<MediaItem>(
                MediaItem("Hesian: Zerotik", "https://i.ytimg.com/vi/E2lD-vp7n-I/maxresdefault.jpg", "G5SWPS9po74"),
                MediaItem("Rev Theory - Hell Yeah", "https://i.ytimg.com/vi/XGLvPYexRJ4/maxresdefault.jpg", "7LuSP4QaXiQ"),
                MediaItem("En Tol Sarmiento - Ametsetan", "http://entolsarmiento.com/wp-content/uploads/2014/11/portada.jpg", "LtDx3hb-KwI"),
                MediaItem("Hesian: Zerotik", "https://i.ytimg.com/vi/E2lD-vp7n-I/maxresdefault.jpg", "G5SWPS9po74"),
                MediaItem("Rev Theory - Hell Yeah", "https://i.ytimg.com/vi/XGLvPYexRJ4/maxresdefault.jpg", "7LuSP4QaXiQ"),
                MediaItem("En Tol Sarmiento - Ametsetan", "http://entolsarmiento.com/wp-content/uploads/2014/11/portada.jpg", "LtDx3hb-KwI"))


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
