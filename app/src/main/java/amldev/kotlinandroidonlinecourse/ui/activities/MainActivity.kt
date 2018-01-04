package amldev.kotlinandroidonlinecourse.ui.activities

import amldev.kotlinandroidonlinecourse.R
import amldev.kotlinandroidonlinecourse.data.MediaProvider
import amldev.kotlinandroidonlinecourse.domain.models.MediaItem
import amldev.kotlinandroidonlinecourse.extensions.toast
import amldev.kotlinandroidonlinecourse.ui.adapters.MediaAdapter
import amldev.kotlinandroidonlinecourse.ui.interfaces.Logger
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Logger {

    // create an adapter using GetMedia.kt data (root/data/GetMedia.kt)
    // Usar lambdas en el Adapter para mostrar lo que se ha declarado en dicha lambda (usando
    // la desestructurando la declaración mediaItem)
    val adapter = MediaAdapter { (title) -> toast(title)  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("Load Media Items!!")
        loadList()
    }

    private fun loadList() {
        // 1. set layoutManger
        recycler.layoutManager = LinearLayoutManager(this)

        // 2. set adapter (initialize before in top)
        recycler.adapter = adapter
        MediaProvider.dataAsync {  adapter.items = it }

        // 3. set item animator to DefaultAnimator
        recycler.itemAnimator = DefaultItemAnimator()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Aquí se filtran los cambios según nuestra selección
        MediaProvider.dataAsync { media ->
            recycler.scrollToPosition(0)
            adapter.items = when (item.itemId) {
                R.id.filter_all -> media
                R.id.filter_videos -> media.filter { it.type == MediaItem.Type.VIDEO}
                R.id.filter_audio -> media.filter { it.type == MediaItem.Type.AUDIO}
                else -> emptyList()
            }
        }


        return super.onOptionsItemSelected(item)
    }
}
